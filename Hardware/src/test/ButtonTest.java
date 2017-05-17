package test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

public class ButtonTest {
  
  // Field
  private GpioPinDigitalInput gpioPinDigitalInput;
  private GpioPinDigitalOutput redPin;
  private GpioPinDigitalOutput greenPin;
  
  public ButtonTest(Pin buttonPinNo, Pin redPinNo, Pin greenPinNo) {
    GpioController gpioController = GpioFactory.getInstance();
    gpioPinDigitalInput = gpioController.provisionDigitalInputPin(buttonPinNo);
    gpioPinDigitalInput.setShutdownOptions(true);
    redPin = gpioController.provisionDigitalOutputPin(redPinNo);
    redPin.setShutdownOptions(true, PinState.LOW);
    greenPin = gpioController.provisionDigitalOutputPin(greenPinNo);
    greenPin.setShutdownOptions(true, PinState.LOW);
  }
  
  public void setGpioPinListenerDigital(GpioPinListenerDigital listener) {
    gpioPinDigitalInput.addListener(listener);
  }
  public static void main(String[] args) throws IOException {
    ButtonTest buttonTest = new ButtonTest(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    buttonTest.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if(event.getState() == PinState.HIGH) {
          buttonTest.greenPin.low();
          buttonTest.redPin.high();
        } else if(event.getState() == PinState.LOW) {
          buttonTest.redPin.low();
          buttonTest.greenPin.high();
        }
      }
    });
    System.out.println("Ready...");
    System.in.read();
  }
}
