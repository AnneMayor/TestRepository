package sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class UltrasonicSensor {

  private GpioPinDigitalOutput trigger;
  private GpioPinDigitalInput echo;

  private int previousDistance;
  private boolean again;
  private int count;

  public UltrasonicSensor(Pin triggerNo, Pin echoNo) {
    GpioController gpioController = GpioFactory.getInstance();

    trigger = gpioController.provisionDigitalOutputPin(triggerNo);
    trigger.setShutdownOptions(true, PinState.LOW);
    echo = gpioController.provisionDigitalInputPin(echoNo);
    echo.setShutdownOptions(true, PinState.LOW);

  }

  public int getDistance() {
    // 초음파 발신 시간 변수와 수신 시간 변수 선언
    double start = 0;
    double end = 0;
    // 초음파를 10마이크로초동안 발생
    trigger.high();
    try {
      Thread.sleep(0, 10000);
    } catch (InterruptedException ex) {
    }
    trigger.low();
    count = 0;
    //echo가 High될 때까지 기다림
    while (echo.isLow()) {
      // 여기서 멈춰주지 않으면 센서가 인식을 하다가 멈춤
      count++;
      if (count > 50000) {
        return getDistance(); // 재귀호출: 자기 자신을 다시 호출
      }
    }
    // 발신 시간 저장
    start = System.nanoTime();
    count = 0;
    while (echo.isHigh()) {
      count++;
      if (count > 50000) {
        return getDistance(); // 재귀호출: 자기 자신을 다시 호출
      }
    }
    end = System.nanoTime();
    // 편도시간(sec)
    double second = (end - start) / 1000000000 / 2;

    // 거리(cm)
    int distance = (int) (second * 34000);
    // 100이상 튀는 값이 있을 경우 다시 측정
    if(again==false && Math.abs(previousDistance-distance) > 100) {
      again = true;
      getDistance(); // 더미: 가짜로 한번 읽어보기(dummy read)
      distance = getDistance();
    } else {
      again = false; 
    }
    // 
    // 초과값 검사(2 ~ 400cm)
    if(distance < 2) {
      distance = 2;
    } else if(distance > 400 ) {
      distance = 400;
    }
    previousDistance = distance;
    return distance;
  }

  public static void main(String... args) throws InterruptedException {
    UltrasonicSensor test = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
    while (true) {
      int distance = test.getDistance();
      System.out.println("거리(cm): " + distance);
      Thread.sleep(1000);
    }
  }
}
