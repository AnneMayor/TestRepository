package test;

import buzzer.ActiveBuzzer;
import com.pi4j.io.gpio.RaspiPin;
import sensor.UltrasonicSensor;

public class UltrasonicTest {

  public static void main(String... args) throws InterruptedException {
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_02);
    UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
    while (true) {
      System.out.println(ultrasonicSensor.getDistance());
      Thread.sleep(1000);
      if (ultrasonicSensor.getDistance() < 20) {
        System.out.println("Warning!");
        buzzer.on();
      } else {
        buzzer.off();
      }
    }
  }
}