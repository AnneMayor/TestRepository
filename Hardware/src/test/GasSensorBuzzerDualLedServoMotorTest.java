package test;

import hardware.buzzer.ActiveBuzzer;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.converter.PCF8591;
import java.io.IOException;
import hardware.led.DualColorLed;
import hardware.motor.SG90Servo;
import hardware.sensor.GasSensor;

public class GasSensorBuzzerDualLedServoMotorTest {
  public static void main(String...args) throws IOException {
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    GasSensor gas = new GasSensor(pcf8591, RaspiPin.GPIO_00);
    ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
    DualColorLed led = new DualColorLed(RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    SG90Servo sg90servo = new SG90Servo(RaspiPin.GPIO_23, 8, 27);
    
    gas.setGpioPinListenerDigital((event) -> {
      if(event.getState() == PinState.LOW) {
        buzzer.on();
        led.red();
        sg90servo.setAngle(180);
      } else {
        buzzer.off();
        led.green();
        sg90servo.setAngle(0);
      }
    });
    
    System.out.println("Start");
    System.in.read();
  }
}
