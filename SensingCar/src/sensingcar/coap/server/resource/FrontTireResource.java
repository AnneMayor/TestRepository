package sensingcar.coap.server.resource;

import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontTireResource extends CoapResource {

   private static final Logger LOGGER = LoggerFactory.getLogger(FrontTireResource.class);
  private PCA9685 pca9685;
  private SG90ServoPCA9685StepDuration servoMotor;
  private final int maxAngle = 120;
  private final int minAngle = 60;
  private int currAngle;
  
  public FrontTireResource() throws Exception {
    super("fronttire");
    pca9685 = PCA9685.getInstance();
    servoMotor = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_00);
    setAngle(90);
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // {"command":"change", "angle":"90"}
    // {"command":"status"}
    try {
      String rqjson = exchange.getRequestText();
      JSONObject rqjsonObject = new JSONObject(rqjson);
      String command = rqjsonObject.getString("command");
      if (command.equals("change")) {
        String reqAngle = rqjsonObject.getString("angle");
        setAngle(Integer.parseInt(reqAngle));
      } else if (command.equals("status")) {
      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("angle", String.valueOf(currAngle));
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
  
  private void setAngle(int angle) {
    if(angle < minAngle) {
      angle = minAngle;
    } else if(angle > maxAngle) {
      angle = maxAngle;
    }
    servoMotor.setAngle(angle);
    currAngle = angle;
  }
}