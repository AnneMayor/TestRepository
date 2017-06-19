package com.mycompany.myapp.service;

import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.RaspiPin;

import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685StepDuration;
import hardware.sensor.UltrasonicSensor;

@Component
public class SensingCarServiceImpl implements SensingCarService {
	// ServiceImpl의 경우 기본 생성자만 써야한다. 생성자 생성하지 않는다!그러나 여기선 생성자 만듦
	private PCA9685 pca9685;
	
//	// 이 클래스 객체가 생성된 이후에 객체 만들기
//	@PostConstruct
//	public void init() throws Exception {
//
//	}

 	// 생성자를 쓰는 대신 초기화를 시키는 코드를 작성해준다.
//	public SensingCarServiceImpl() throws Exception {
//		// 생성자에서 try-catch 안 잡는게 좋음.
//		pca9685 = PCA9685.getInstance();
//	}

	@Override
	public void changeUltrasonicSensorAngle(int angle) throws Exception {
		try {
			pca9685 = PCA9685.getInstance();
			SG90ServoPCA9685StepDuration servo = new SG90ServoPCA9685StepDuration(pca9685, PCA9685.PWM_11);
			servo.setAngle(angle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	};

	@Override
	public int getUltrasonicSensorDistance() throws Exception {
		UltrasonicSensor test = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		return test.getDistance();
	}
}
