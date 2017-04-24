package ch07.exam07;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car(new SnowTire()); // 이런 코드도 있군...참고하자!
		car.run();
		
		car.setTire(new NormalTire()); // 여기가 부품교체군...
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
		car.setTire(new SuperTire());
		car.run();
	}
}