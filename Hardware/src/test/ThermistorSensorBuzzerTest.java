package test;

import buzzer.ActiveBuzzer;
import com.pi4j.io.gpio.RaspiPin;
import converter.PCF8591;
import sensor.ThermistorSensor;

public class ThermistorSensorBuzzerTest {

  public static void main(String... args) throws Exception {
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_00);
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    ThermistorSensor thermistorSensor = new ThermistorSensor(pcf8591);

    while (true) {
      double value = thermistorSensor.getValue();
      System.out.println(value);
      if(value >= 28.0) {
        // if(buzzer.getStatus().equals("off")) {} -> 이렇게도 가능.
        buzzer.on();
      } else {
        buzzer.off();
      }
      Thread.sleep(1000);
    }
  }
}
