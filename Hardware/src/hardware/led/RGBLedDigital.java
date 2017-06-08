package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class RGBLedDigital {

  private GpioPinDigitalOutput redPin;
  private GpioPinDigitalOutput greenPin;
  private GpioPinDigitalOutput bluePin;

  public RGBLedDigital(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
    GpioController gpioController = GpioFactory.getInstance();

    redPin = gpioController.provisionDigitalOutputPin(redPinNo, PinState.HIGH);
    greenPin = gpioController.provisionDigitalOutputPin(greenPinNo, PinState.HIGH);
    bluePin = gpioController.provisionDigitalOutputPin(bluePinNo, PinState.HIGH);

    redPin.setShutdownOptions(true, PinState.LOW);
    greenPin.setShutdownOptions(true, PinState.LOW);
    bluePin.setShutdownOptions(true, PinState.LOW);

  }

  public static void main(String[] args) throws InterruptedException {
    RGBLedDigital test = new RGBLedDigital(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
    while (true) {
      test.rgb(true, false, false);
      Thread.sleep(100);
      test.rgb(false, true, false);
      Thread.sleep(100);
      test.rgb(false, false, true);
      Thread.sleep(100);
    }
  }

  public void rgb(Boolean red, Boolean green, Boolean blue) {
    if (red) {
      redPin.low();
    } else {
      redPin.high();
    }

    if (green) {
      greenPin.low();
    } else {
      greenPin.high();
    }

    if (blue) {
      bluePin.low();
    } else {
      bluePin.high();
    }
  }

  /*
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
   */
  public void redOnOff(Boolean state) {
    if (state == true) {
      redPin.low();
    } else {
      redPin.high();
    }
  }

  public void greenOnOff(Boolean state) {
    if (state == true) {
      greenPin.low();
    } else {
      greenPin.high();
    }
  }

  public void blueOnOff(Boolean state) {
    if (state == true) {
      bluePin.low();
    } else {
      bluePin.high();
    }
  }
}
