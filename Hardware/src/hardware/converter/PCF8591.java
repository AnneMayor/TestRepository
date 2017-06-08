package hardware.converter;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class PCF8591 {
  public static final int AIN0 = 0x40;
  public static final int AIN1 = 0x41;
  public static final int AIN2 = 0x42;
  public static final int AIN3 = 0x43;
  
  private int i2cAddress;
  private int ainNo;
  private int analogVal;
  
  public PCF8591(int i2cAddress, int ainNo) {
    this.i2cAddress = i2cAddress;
    this.ainNo = ainNo;
  }
  
  public int analogRead() throws Exception {
    I2CBus i2CBus = I2CFactory.getInstance(I2CBus.BUS_1);
    I2CDevice i2cDevice = i2CBus.getDevice(i2cAddress);
    i2cDevice.read(ainNo);
    analogVal = i2cDevice.read(ainNo);
    return analogVal;
  }
  
  public void analogWrite(byte value) {
    try {
      I2CBus i2CBus = I2CFactory.getInstance(I2CBus.BUS_1);
      I2CDevice i2cDevice = i2CBus.getDevice(i2cAddress);
      i2cDevice.write(AIN0, value);
    } catch(Exception e) {
    }
  }
  
  public static void main(String...args) throws Exception {
    PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
    while(true) {
      // 아날로그 값 읽기
      int value = pcf8591.analogRead();
      System.out.println(value);
      // 아날로그 값 출력
      pcf8591.analogWrite((byte)value);
      Thread.sleep(50);
    }
    
  }
}