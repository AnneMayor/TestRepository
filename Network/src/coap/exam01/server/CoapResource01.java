package coap.exam01.server;

import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource01 extends CoapResource {
  
  private ThermistorSensor thermistorSensor;
  
  public CoapResource01() {
    // 아래가 리소스 식별명
    super("resource01");
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
    thermistorSensor = new ThermistorSensor(pcf8591);
  }

  @Override
  public void handleGET(CoapExchange exchange) {
    double value;
    try {
      value = thermistorSensor.getValue();
      exchange.respond("Temperature: " + value + "C");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
