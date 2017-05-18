package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import button.Button;
import buzzer.ActiveBuzzer;
import java.io.IOException;

public class ButtonActiveBuzzer {

  public static void main(String... args) throws IOException {
    Button button = new Button(RaspiPin.GPIO_02);
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_00);

    button.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if (event.getState() == PinState.LOW) {
          buzzer.on();
        } else {
          buzzer.off();
        }
      }
    });
    System.out.println("Ready...");
    System.in.read();
  }
}
