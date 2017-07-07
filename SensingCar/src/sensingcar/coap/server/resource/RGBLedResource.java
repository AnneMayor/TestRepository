package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.led.RGBLedPWM;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RGBLedResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(RGBLedResource.class);
  private RGBLedPWM rgbLed;
  private int currRed;
  private int currBlue;
  private int currGreen;

  public RGBLedResource() throws Exception {
    super("rgbled");
    rgbLed = new RGBLedPWM(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);
    setColor(0, 0, 0);
  }

  private void setColor(int red, int green, int blue) {
    rgbLed.ledColorSet(red, green, blue);
    currRed = red;
    currGreen = green;
    currBlue = blue;
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // {"command":"change", "red":"100", "green":"100", "blue":"100"}
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("change")) {
        int red = Integer.parseInt(reqJsonObject.getString("red"));
        int green = Integer.parseInt(reqJsonObject.getString("green"));
        int blue = Integer.parseInt(reqJsonObject.getString("blue"));
        setColor(red, green, blue);
      } else if (command.equals("status")) {

      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("red", String.valueOf(currRed));
      rsjsonObject.put("green", String.valueOf(currGreen));
      rsjsonObject.put("blue", String.valueOf(currBlue));

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