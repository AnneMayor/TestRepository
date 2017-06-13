package coap.sensingcar.server;

import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource05 extends CoapResource {

  private double temperature;

  public CoapResource05() {
    super("resource05");
    setObservable(true);
    getAttributes().setObservable();
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
    ThermistorSensor thermistorSensor = new ThermistorSensor(pcf8591);

    Thread thread = new Thread() {
      @Override
      public void run() {

        try {
          while (true) {
            temperature = thermistorSensor.getValue();
            changed();
            Thread.sleep(1000);
          }
        } catch (Exception ex) {
        }
      }
    };
    thread.start();
  }

  @Override
  public void handleGET(CoapExchange exchange) {
    exchange.respond(temperature + "C");
  }
}
