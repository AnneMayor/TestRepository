package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.sensor.TrackingSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackingSensorResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrackingSensorResource.class);
  private TrackingSensor trackingSensor;
  private String currColor;

  // 라이브러리에 들어있는 프로젝트 jar파일은 본 프로젝트에서 수정하면 jar파일은 자동적으로 수정된다.
  public TrackingSensorResource() throws Exception {
    super("tracking");
    setObservable(true);
    getAttributes().setObservable();
    setObserveType(CoAP.Type.NON);

    trackingSensor = new TrackingSensor(RaspiPin.GPIO_26);

    Thread thread = new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            PinState pinState = trackingSensor.getStatus();
            if (pinState == PinState.HIGH) {
              currColor = "black";
            } else if (pinState == PinState.LOW) {
              currColor = "white";
            }
            changed();
            Thread.sleep(500);
          } catch (Exception e) {
            LOGGER.info(e.toString());
          }
        }
      }
    };
    thread.start();

//    trackingSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
//      @Override
//      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//        PinState pinState = event.getState();
//        if (pinState == PinState.HIGH) {
//          BuzzerResource.getInstance().off();
//        } else {
//          BuzzerResource.getInstance().on();
//        }
//      }
//
//    });
  }

  @Override
  public void handleGET(CoapExchange exchange) {

    JSONObject rsjsonObject = new JSONObject();
    rsjsonObject.put("trackingsensor", currColor);
    String rsJson = rsjsonObject.toString();
    exchange.respond(rsJson);
  }

  @Override
  // 관찰요청이 한번만 왔을 때 시행할 메소드(이건 관찰하지 않음)
  public void handlePOST(CoapExchange exchange) {
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("status")) {
      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("trackingsensor", currColor);
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
