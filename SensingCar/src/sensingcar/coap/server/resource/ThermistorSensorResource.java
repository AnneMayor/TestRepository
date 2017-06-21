package sensingcar.coap.server.resource;

import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThermistorSensorResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(ThermistorSensorResource.class);
  private ThermistorSensor thermistor;
  private double currTemperature;
  private PCF8591 pcf8591;

  // 라이브러리에 들어있는 프로젝트 jar파일은 본 프로젝트에서 수정하면 jar파일은 자동적으로 수정된다.
  public ThermistorSensorResource() throws Exception {
    super("thermistor");
    setObservable(true);
    getAttributes().setObservable();
    setObserveType(CoAP.Type.NON);

    pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
    thermistor = new ThermistorSensor(pcf8591);
    
    Thread thread = new Thread() {
      @Override
      public void run() {
       while (true) {
          try {
            currTemperature = thermistor.getValue();
            changed();
            Thread.sleep(500);
          } catch (Exception e) {
            LOGGER.info(e.toString());
          }
       }
      }
    };
    thread.start();
  }

  @Override
  public void handleGET(CoapExchange exchange) {

    JSONObject rsjsonObject = new JSONObject();
    rsjsonObject.put("temperature", String.valueOf(currTemperature));
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
      rsjsonObject.put("temperature", String.valueOf(currTemperature));
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
