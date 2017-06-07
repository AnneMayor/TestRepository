package buzzer;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class ActiveBuzzer {
  private GpioPinDigitalOutput buzzerPin;
  private String status = "off";
  
  public ActiveBuzzer(Pin pinNo) {
    GpioController gpioController = GpioFactory.getInstance();
    buzzerPin = gpioController.provisionDigitalOutputPin(pinNo);
    buzzerPin.setState(PinState.HIGH);
    // 브레드보드에 핀을 꽃으면 미세한 전류로 인하여 소리가 남. 이걸 막기 위해 다음 아래의 코드를 작성.
    buzzerPin.setShutdownOptions(false, PinState.HIGH);
  }
  
  public void on() {
    buzzerPin.low();
    status="on";
    
  }
  
  public void off() {
    buzzerPin.high();
    status="off";
  }
  
  public String getStatus() {
    return status;
  }
  
  public static void main(String...args) throws InterruptedException {
    ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
    for(int i = 5; i > 0; i--) {
      activeBuzzer.on();
      Thread.sleep(100);
      activeBuzzer.off();
      Thread.sleep(100);
    }
  }
}