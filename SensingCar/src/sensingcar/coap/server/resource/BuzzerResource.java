package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import static java.lang.Compiler.command;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuzzerResource extends CoapResource {

   private static final Logger LOGGER = LoggerFactory.getLogger(BuzzerResource.class);
  private ActiveBuzzer buzzer;
  private String currStatus;

  public BuzzerResource() throws Exception {
    super("buzzer");
    buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
    off();
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // {"command":"change", "status":"on"}
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("change")) {
        String status = reqJsonObject.getString("status");
        if (status.equals("on")) {
          on();
        } else if (status.equals("off")) {
          off();
        }
      } else if (command.equals("status")) {

      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("status", currStatus);
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

  private void on() {
    buzzer.on();
    currStatus = "on";
  }

  private void off() {
    buzzer.off();
    currStatus = "off";
  }
}
