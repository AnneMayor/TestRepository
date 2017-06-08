package test;
import hardware.buzzer.ActiveBuzzer;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;
import hardware.sensor.TrackingSensor;

public class TrackingSensorTest {
  public static void main(String...args) throws IOException {
  ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
  TrackingSensor tracking = new TrackingSensor(RaspiPin.GPIO_00);
  
  tracking.setGpioPinListenerDigital(event -> {
    if(event.getState() == PinState.HIGH) {
      buzzer.on();
    } else {
      buzzer.off();
    }
  });
  
  System.out.println("Ready");
  System.in.read();
  }
}
