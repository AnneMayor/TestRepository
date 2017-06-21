package com.mycompany.myapp.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.GasSensorDao;
import com.pi4j.io.gpio.RaspiPin;

import hardware.converter.PCF8591;
import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import hardware.sensor.GasSensor;
import hardware.sensor.UltrasonicSensor;

@Component
public class SensingCarServiceImpl implements SensingCarService {
	// ServiceImpl의 경우 기본 생성자만 써야한다. 생성자 생성하지 않는다!그러나 여기선 생성자 만듦

	// 하드웨어 PWM 관련 필드
	private PCA9685 pca9685;
	// ADC 관련 필드
	
	@Autowired
	private GasSensorDao gasSensor;
	
	// 초음파 센서 관련 필드 초기화
	private SG90ServoPCA9685StepDuration ultrasonicSensorServo;
	private UltrasonicSensor ultrasonicSensor;

	// Gas 센서 관련 필드
	private PCF8591 gasSensorPCF8591;
	private GasSensor gas;

	// 이 클래스 객체가 생성된 이후에 객체 만들기
	@PostConstruct
	public void init() throws Exception {
		pca9685 = PCA9685.getInstance();
		
		ultrasonicSensorServo = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_11);
		ultrasonicSensor = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		
		gasSensorPCF8591 = new PCF8591(0x48, PCF8591.AIN2);
		gas = new GasSensor(gasSensorPCF8591, RaspiPin.GPIO_23);
	}

	// 생성자를 쓰는 대신 초기화를 시키는 코드를 작성해준다.
	// public SensingCarServiceImpl() throws Exception {
	// // 생성자에서 try-catch 안 잡는게 좋음.
	// pca9685 = PCA9685.getInstance();
	// }

	@Override
	public void changeUltrasonicSensorAngle(int angle) throws Exception {
		ultrasonicSensorServo.setAngle(angle);
	}

	@Override
	public int getUltrasonicSensorDistance() throws Exception {
		return ultrasonicSensor.getDistance();
	}

	@Override
	public double getGasSensorValue() throws Exception {
		
		// 센서로부터 측정값 받기
		double value = gas.getValue();
		// DB에 저장할 객체 생성
		com.mycompany.myapp.dto.GasSensor gasSensorBean = new com.mycompany.myapp.dto.GasSensor();
		gasSensorBean.setGvalue(value);
		
		gasSensor.insert(gasSensorBean);
		return value;
	}
}