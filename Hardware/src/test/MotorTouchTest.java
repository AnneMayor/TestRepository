package test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import motor.SG90Servo;

public class MotorTouchTest {

  private GpioPinDigitalInput touch;

  public MotorTouchTest(Pin touchNo) {
    GpioController gpioController = GpioFactory.getInstance();
    touch = gpioController.provisionDigitalInputPin(touchNo);
  }

  public void setGpioPinListenerDigital(GpioPinListenerDigital listener) {
    touch.addListener(listener);
  }

  public static void main(String... args) throws IOException {
    MotorTouchTest motorTouch = new MotorTouchTest(RaspiPin.GPIO_00);
    SG90Servo motor = new SG90Servo(RaspiPin.GPIO_01, 8, 27);
    motorTouch.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if (event.getState() == PinState.HIGH) {
          motor.setAngle(0);
        } else if(event.getState() == PinState.LOW) {
          for (int i = 0; i < 180; i += 10) {
            motor.setAngle(i);
            try {
              Thread.sleep(500);
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
          }
        }
      }
    });
    System.out.println("Ready...");
    System.in.read();
  }
}
