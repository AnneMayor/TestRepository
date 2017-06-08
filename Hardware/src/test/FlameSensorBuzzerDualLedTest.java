package test;

import hardware.buzzer.ActiveBuzzer;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.converter.PCF8591;
import java.io.IOException;
import hardware.led.DualColorLed;
import hardware.sensor.FlameSensor;

public class FlameSensorBuzzerDualLedTest {
  public static void main(String...args) throws IOException {
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
    DualColorLed color = new DualColorLed(RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    FlameSensor flame = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
    
    
    color.green();
    flame.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if(event.getState() == PinState.LOW) {
          buzzer.on();
          color.red();
        } else {
          buzzer.off();
          color.green();
        }
      }
    });
    System.out.println("Start");
    System.in.read();
  }
}
