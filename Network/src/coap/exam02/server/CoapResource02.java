package coap.exam02.server;

import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import hardware.sensor.UltrasonicSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;

public class CoapResource02 extends CoapResource {

  private SG90ServoPCA9685StepDuration servoMotor;
  private PCA9685 pca9685;
  private UltrasonicSensor ultrasonic;
  private int distance;

  public CoapResource02() throws Exception {
    super("resource02");
    pca9685 = PCA9685.getInstance();
    servoMotor = new SG90ServoPCA9685StepDuration(pca9685, PCA9685Pin.PWM_11);
    ultrasonic = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);

    // distance 측정 쓰레드 추가!
    Thread thread = new Thread() {
      @Override
      public void run() {
        while (true) {
          distance = ultrasonic.getDistance();
          try {
            Thread.sleep(100);
          } catch (InterruptedException ex) {
          }
        }
      }
    };
    thread.start();
  }

  @Override
  public void handleGET(CoapExchange exchange) {
    String key1 = exchange.getRequestOptions().getUriQuery().get(0);
    String key2 = exchange.getRequestOptions().getUriQuery().get(1);

    String[] keyName1 = key1.split("=");
    String[] keyName2 = key2.split("=");
    if (keyName1[1].equals("ultrasonicsensor")) {
      servoMotor.setAngle(Integer.parseInt(keyName2[1]));
      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        System.out.println("error");
      }
      exchange.respond(String.valueOf(distance));
    } else {
      exchange.respond("");
    }
  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    String json = exchange.getRequestText();
    JSONObject jsonObject = new JSONObject(json);
    String kind = jsonObject.getString("kind");
    int angle = jsonObject.getInt("angle");
//    String queryString = exchange.getRequestText();
//    System.out.println(queryString);
//    String kind = queryString.split("&")[0].split("=")[1];
//    String angle = queryString.split("&")[1].split("=")[1];
     if (kind.equals("ultrasonicsensor")) {
      servoMotor.setAngle(angle);
      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        System.out.println("error");
      }
      exchange.respond(String.valueOf(distance));
    } else {
      exchange.respond("");
    }
  }
}