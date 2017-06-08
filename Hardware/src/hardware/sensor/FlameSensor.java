package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.converter.PCF8591;

public class FlameSensor {

  private PCF8591 pcf8591;
  private GpioPinDigitalInput gpioPinDigitalInput;

  public FlameSensor(PCF8591 pcf8591, Pin digitalPinNo) {
    GpioController gpioController = GpioFactory.getInstance();
    gpioPinDigitalInput = gpioController.provisionDigitalInputPin(digitalPinNo);
    gpioPinDigitalInput.setShutdownOptions(true, PinState.LOW);
    this.pcf8591 = pcf8591;
  }

  public void setGpioPinListenerDigital(GpioPinListenerDigital listener) {
    gpioPinDigitalInput.addListener(listener);
  }

  public int getValue() throws Exception {
    int analogVal = pcf8591.analogRead();
    return analogVal;
  }

  public static void main(String... args) throws Exception {
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    FlameSensor flame = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
    // 방법1: Digital 핀의 상태를 이용
    flame.setGpioPinListenerDigital(new GpioPinListenerDigital() {
      @Override
      public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        if(event.getState() == PinState.LOW) {
          System.out.println("Alert: Flame is detected");
        } else {
          System.out.println("You are safe");
        }
      }
    });

    // 방법2: Analog값을 이용하여 처리
    
    while (true) {
      int value = flame.getValue();
      System.out.println(value);
      if(value < 100) {
        // Analog 값을 이용하여 처리
      }
      Thread.sleep(1000);
    }
  }
}