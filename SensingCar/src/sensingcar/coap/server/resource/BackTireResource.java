package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.DCMotor;
import hardware.motor.PCA9685;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackTireResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(BackTireResource.class);
  private DCMotor dcMotorLeft;
  private DCMotor dcMotorRight;
  private PCA9685 pca9685;
  private final int maxStep = 4095;
  private final int minStep = 0;
  private int currStep;
  private String currDirection;

  public BackTireResource() throws Exception {
    super("backtire");
    pca9685 = PCA9685.getInstance();
    dcMotorLeft = new DCMotor(RaspiPin.GPIO_00, RaspiPin.GPIO_01, pca9685, PCA9685.PWM_05);
    dcMotorRight = new DCMotor(RaspiPin.GPIO_02, RaspiPin.GPIO_03, pca9685, PCA9685.PWM_04);
    forward();
  }

  public void forward() {
    dcMotorLeft.forward();
    dcMotorRight.forward();
    currDirection = "forward";
  }

  public void backward() {
    dcMotorLeft.backward();
    dcMotorRight.backward();
    currDirection = "backward";
  }

  public void setSpeed(int step) {
    if (step < minStep) {
      step = minStep;
    }
    if (step > maxStep) {
      step = maxStep;
    }
    currStep = step;
    dcMotorLeft.setSpeed(currStep);
    dcMotorRight.setSpeed(currStep);
  }

  public void stop() {
    dcMotorLeft.stop();
    dcMotorRight.stop();
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // {"command":"change", "direction":"forward", "speed":"1000"}
    // {"command":"status"} 이렇게 총 3개의 json을 보내주기
    try {
      String rqjson = exchange.getRequestText();
      JSONObject rqjsonObject = new JSONObject(rqjson);
      String command = rqjsonObject.getString("command");
      if (command.equals("change")) {
        String reqDirection = rqjsonObject.getString("direction");
        String reqSpeed = rqjsonObject.getString("speed");
        if (reqDirection.equals("forward")) {
          forward();
        } else if (reqDirection.equals("backward")) {
          backward();
        }
        setSpeed(Integer.parseInt(reqSpeed));
      } else if (command.equals("status")) {
      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("direction", currDirection);
      rsjsonObject.put("speed", String.valueOf(currStep));
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
