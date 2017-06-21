package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import hardware.sensor.UltrasonicSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltrasonicSensorResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(UltrasonicSensorResource.class);
  private PCA9685 pca9685;
  private SG90ServoPCA9685StepDuration servoMotor;
  private UltrasonicSensor ultrasonic;
  private int currAngle;
  private final int minAngle = 10;
  private final int maxAngle = 170;
  private int currDistance;

  // 라이브러리에 들어있는 프로젝트 jar파일은 본 프로젝트에서 수정하면 jar파일은 자동적으로 수정된다.
  public UltrasonicSensorResource() throws Exception {
    super("ultrasonicsensor");
    setObservable(true);
    getAttributes().setObservable();
    pca9685 = PCA9685.getInstance();
    setObserveType(CoAP.Type.NON);
    servoMotor = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_11);
    ultrasonic = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
    setAngle(90);
    Thread thread = new Thread() {
      @Override
      public void run() {
        int count = 0;
        while (true) {
          try {
            currDistance = ultrasonic.getDistance();
            Thread.sleep(500);
            if (count == 2) {
              changed();
              count = 0;
            } else {
              count++;
            }
          } catch (Exception e) {
            LOGGER.info(e.toString());
          }
        }
      }
    };
    thread.start();
  }

  private void setAngle(int angle) {
    if (angle < minAngle) {
      angle = minAngle;
    } else if (angle > maxAngle) {
      angle = maxAngle;
    }
    servoMotor.setAngle(angle);
    currAngle = angle;

    currDistance = ultrasonic.getDistance();
  }

  @Override
  public void handleGET(CoapExchange exchange) {

    JSONObject rsjsonObject = new JSONObject();
    rsjsonObject.put("distance", String.valueOf(currDistance));
    rsjsonObject.put("angle", String.valueOf(currAngle));
    String rsJson = rsjsonObject.toString();
    exchange.respond(rsJson);
  }

  @Override
  // 관찰요청이 한번만 왔을 때 시행할 메소드(이건 관찰하지 않음)
  public void handlePOST(CoapExchange exchange) {
    // { "command":"change", "angle":"90"}
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("change")) {
        int angle = Integer.parseInt(reqJsonObject.getString("angle"));
        setAngle(angle);
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
        }
      } else if (command.equals("status")) {
      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("angle", String.valueOf(currAngle));
      rsjsonObject.put("distance", String.valueOf(currDistance));
      String rsjson = rsjsonObject.toString();
      exchange.respond(rsjson);
    } catch (Exception e) {
      LOGGER.info(e.toString());
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "fail");
      String rsjson = rsjsonObject.toString();
      exchange.respond(rsjson);
    }
  }
}
