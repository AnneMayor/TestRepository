package led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class RGBLed {
  private GpioPinDigitalOutput redPin;
  private GpioPinDigitalOutput greenPin;
  private GpioPinDigitalOutput bluePin;
  
  public RGBLed(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
    GpioController gpioController = GpioFactory.getInstance();
    
    redPin = gpioController.provisionDigitalOutputPin(redPinNo, PinState.HIGH);
    greenPin = gpioController.provisionDigitalOutputPin(greenPinNo, PinState.HIGH);
    bluePin = gpioController.provisionDigitalOutputPin(bluePinNo, PinState.HIGH);
    
    redPin.setShutdownOptions(true, PinState.LOW);
    greenPin.setShutdownOptions(true, PinState.LOW);
    bluePin.setShutdownOptions(true, PinState.LOW);
    
  }
  
  public static void main(String[] args) throws InterruptedException {
    RGBLed rgb = new RGBLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
    while(true) {
      rgb.red();
      Thread.sleep(100);
      rgb.green();
      Thread.sleep(100);
      rgb.blue();
      Thread.sleep(100);
    }
   }
  
  public void red() {
    redPin.low();
    greenPin.high();
    bluePin.high();
  }
  
  public void green() {
    redPin.high();
    greenPin.low();
    bluePin.high();
  }
  
  public void blue() {
    redPin.high();
    greenPin.high();
    bluePin.low();
  }
}
