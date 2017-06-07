package motor;

import com.pi4j.io.gpio.Pin;

public class SG90ServoPCA9685Step {
  
  private PCA9685 pca9685;
  private Pin pin;
  private int angle;
  private int minStep;
  private int maxStep;
  
  public SG90ServoPCA9685Step(PCA9685 pca9685, Pin pin) {
    // 1단계(단위 펄스 시간) = 20ms/4096 = 0.004884ms
    // 0도(0.8/0.004884 = 164 단계)
    // 180도(2.7/0.004884 = 552단계)
    // 90도(1.75/0.004884 = 358단계)
    this(pca9685, pin, 164, 552);
  }
  
  public void setAngle(int angle) {
    if (angle < 0) {
      angle = 0;
    } else if (angle > 180) {
      angle = 180;
    }
    this.angle = angle;
    int step = minStep + (int) (angle * (maxStep - minStep) / 180.0);
    this.pca9685.setStep(pin, step);
  }
  
  public int getAngle() {
    return angle;
  }
  
  public SG90ServoPCA9685Step(PCA9685 pca9685, Pin pin, int minStep, int maxStep) {
    this.pca9685 = pca9685;
    this.pin = pin;
    this.minStep = minStep;
    this.maxStep = maxStep;
  }
  
  public static void main(String... args) throws Exception {
    PCA9685 pca9685 = PCA9685.getInstance();
    SG90ServoPCA9685Step servo = new SG90ServoPCA9685Step(pca9685, PCA9685.PWM_15);

//    for (int i = 10; i <= 180; i+=10) {
//      servo.setAngle(i);
//      Thread.sleep(500);
//    }
//    
//    for(int i = 180; i >= 10; i-=10) {
//      servo.setAngle(i);
//      Thread.sleep(500);
//    } 
    servo.setAngle(180);
    
    System.in.read();
  }
}
