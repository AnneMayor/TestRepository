package hardware.sensor;

import hardware.converter.PCF8591;

public class PhotoresistorSensor {

  private PCF8591 pcf8591;

  public PhotoresistorSensor(PCF8591 pcf8591) {
    this.pcf8591 = pcf8591;
  }

  public int getValue() throws Exception {
    int analogVal = pcf8591.analogRead();
    return analogVal;
  }

  public static void main(String... args) throws Exception {
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    PhotoresistorSensor photoregisterSensor = new PhotoresistorSensor(pcf8591);
    while (true) {
      int value = photoregisterSensor.getValue();
      System.out.println(value);
      Thread.sleep(1000);
    }
  }
}
