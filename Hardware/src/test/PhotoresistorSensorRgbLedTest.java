package test;

import com.pi4j.io.gpio.RaspiPin;
import converter.PCF8591;
import led.RGBLedDigital;
import sensor.PhotoresistorSensor;

public class PhotoresistorSensorRgbLedTest {

  public static void main(String... args) throws Exception {
    RGBLedDigital rgb = new RGBLedDigital(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    PhotoresistorSensor photoresistor = new PhotoresistorSensor(pcf8591);

    while (true) {
      if (photoresistor.getValue() >= 100) {
        rgb.redOnOff(true);
        rgb.greenOnOff(false);
        rgb.blueOnOff(false);
      } else if (photoresistor.getValue() < 100 && photoresistor.getValue() > 30) {
        rgb.blueOnOff(true);
        rgb.redOnOff(false);
        rgb.greenOnOff(false);
      } else if(photoresistor.getValue() <= 30) {
        rgb.greenOnOff(true);
        rgb.redOnOff(false);
        rgb.blueOnOff(false);
      }
    }
  }
}
