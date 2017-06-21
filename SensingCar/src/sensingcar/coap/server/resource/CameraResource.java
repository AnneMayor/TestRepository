package sensingcar.coap.server.resource;

import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraResource extends CoapResource {

   private static final Logger LOGGER = LoggerFactory.getLogger(CameraResource.class);
  private SG90ServoPCA9685StepDuration leftRightMotor;
  private SG90ServoPCA9685StepDuration upDownMotor;
  private PCA9685 pca9685;
  private final int minLeftRight = 10;
  private final int maxLeftRight = 170;
  private final int minUpDown = 10;
  private final int maxUpDown = 100;
  private int currLeftRight;
  private int currUpDown;

  public CameraResource() throws Exception {
    super("camera");
    pca9685 = PCA9685.getInstance();
    leftRightMotor = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_14);
    upDownMotor = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_15);
    turnLeftRight(90);
    turnUpDown(10);
  }

  private void turnLeftRight(int angle) {
    if (angle < minLeftRight) {
      angle = minLeftRight;
    } else if (angle > maxLeftRight) {
      angle = maxLeftRight;
    }
    leftRightMotor.setAngle(angle);
    currLeftRight = angle;
  }

  private void turnUpDown(int angle) {
    if (angle < minUpDown) {
      angle = minUpDown;
    } else if(angle > maxUpDown) {
      angle = maxUpDown;
    }
    upDownMotor.setAngle(angle);
    currUpDown = angle;
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // {"command":"change", "leftright":"90", "updown":"10"}
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("change")) {
        int leftright =  Integer.parseInt(reqJsonObject.getString("leftright"));
        int updown = Integer.parseInt(reqJsonObject.getString("updown"));
        turnLeftRight(leftright);
        turnUpDown(updown);
      } else if (command.equals("status")) {

      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("leftright", String.valueOf(currLeftRight));
      rsjsonObject.put("updown", String.valueOf(currUpDown));
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
