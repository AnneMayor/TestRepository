package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;

public class RGBLedPWM {

  private GpioPinPwmOutput redPin;
  private GpioPinPwmOutput greenPin;
  private GpioPinPwmOutput bluePin;
  private int[] currentColorSet = new int[3];

  public RGBLedPWM(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
    GpioController gpioController = GpioFactory.getInstance();
    // 소프트웨어 PWM 출력 핀 객체 생성
    redPin = gpioController.provisionSoftPwmOutputPin(redPinNo);
    greenPin = gpioController.provisionSoftPwmOutputPin(greenPinNo);
    bluePin = gpioController.provisionSoftPwmOutputPin(bluePinNo);

    // 제어 단계를 255 단계(실제 밝기가 255단계는 아님.)
    redPin.setPwmRange(255);
    greenPin.setPwmRange(255);
    bluePin.setPwmRange(255);
    // 발광하지 않도록 초기화(임베디드 장치에선 입력을 한번 더 시행해야할 일이 없기에 이렇게 써줘도 무방. setShutdownOptions()이건 굳이 쓰지않아도 문제 없음)
    ledColorSet(0, 0, 0);
  }

  public void ledColorSet(int red, int green, int blue) {
    currentColorSet[0] = red;
    currentColorSet[1] = green;
    currentColorSet[2] = blue;
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
    redPin.setPwm(red);
    greenPin.setPwm(green);
    bluePin.setPwm(blue);
  }

  public int[] getCurrentColorSet() {
    return currentColorSet;
  }

  public static void main(String... args) throws IOException, InterruptedException {
    RGBLedPWM test = new RGBLedPWM(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);

    test.ledColorSet(255, 0, 0);
    Thread.sleep(1000);
    test.ledColorSet(0, 255, 0);
    Thread.sleep(1000);
    test.ledColorSet(0, 0, 255);
    Thread.sleep(1000);
    test.ledColorSet(255, 255, 0);
    Thread.sleep(1000);
    test.ledColorSet(0, 255, 255);
    Thread.sleep(1000);
    test.ledColorSet(255, 0, 255);
    Thread.sleep(1000);
    test.ledColorSet(0, 0, 0);
    
    System.out.println("Ready...");
    System.in.read();
  }
}