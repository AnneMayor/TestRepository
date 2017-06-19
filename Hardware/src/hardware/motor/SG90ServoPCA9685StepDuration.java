package hardware.motor;

import com.pi4j.io.gpio.Pin;

public class SG90ServoPCA9685StepDuration {

  private PCA9685 pca9685;
  private Pin pin;
  private int angle;
  private int minDuration;
  private int maxDuration;

  public SG90ServoPCA9685StepDuration(PCA9685 pca9685, Pin pin) {
    // 1단계(단위 펄스 시간) = 20ms/4096 = 0.004884ms
    // 0도(0.8/0.004884 = 800us)
    // 180도(2.7/0.004884 = 2700us)
    // 90도(1.75/0.004884 = 1750us)
    this(pca9685, pin, 800, 2700);
  }

  public void setAngle(int angle) {
    if (angle < 0) {
      angle = 0;
    } else if (angle > 180) {
      angle = 180;
    }
    this.angle = angle;
    int duration = minDuration + (int) (angle * (maxDuration - minDuration) / 180.0);
    this.pca9685.setDuration(pin, duration);
  }

  public int getAngle() {
    return angle;
  }

  public SG90ServoPCA9685StepDuration(PCA9685 pca9685, Pin pin, int minDuration, int maxDuration) {
    this.pca9685 = pca9685;
    this.pin = pin;
    this.minDuration = minDuration;
    this.maxDuration = maxDuration;
  }

  public static void main(String... args) throws Exception {
    PCA9685 pca9685 = PCA9685.getInstance();
    SG90ServoPCA9685StepDuration servo = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_11);
    SG90ServoPCA9685StepDuration servo1 = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_14);
    SG90ServoPCA9685StepDuration servo2 = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_15);
    SG90ServoPCA9685StepDuration servo3 = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_00);
    
//    servo.setAngle(0);
//    Thread.sleep(1000);
//    
//    servo1.setAngle(90);
//    Thread.sleep(1000);
//    
//    servo2.setAngle(90);
//    Thread.sleep(1000);
//    
    servo3.setAngle(0);
    Thread.sleep(1000);
    
//    for (int i = 10; i <= 170; i+=10) {
//      servo.setAngle(i);
//      Thread.sleep(500);
//    }
//    
//    for(int i = 170; i >= 10; i-=10) {
//      servo.setAngle(i);
//      Thread.sleep(500);
//    }
//    
//    System.in.read();
  }
}