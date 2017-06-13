package coap.sensingcar.server;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.RGBLedPWM;
import hardware.sensor.GasSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource06 extends CoapResource {

  String text;

  public CoapResource06() throws Exception {
    super("resource06");
    setObservable(true);
    getAttributes().setObservable();
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN2);
    GasSensor gas = new GasSensor(pcf8591, RaspiPin.GPIO_23);
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
    RGBLedPWM rgb = new RGBLedPWM(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);
    
    gas.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if (event.getState() == PinState.LOW) {
          text = "가스검출";
          buzzer.on();
          rgb.ledColorSet(255, 0, 0);
        } else {
          text = "가스잠김";
          buzzer.off();
          rgb.ledColorSet(255, 255, 255);
        }
        changed();
      }
    });
  }

  @Override

  public void handleGET(CoapExchange exchange) {
    exchange.respond(text);
  }
}
