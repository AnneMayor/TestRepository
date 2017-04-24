package HW01;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car();
		
		car1.keyTurnOn();
		car1.run();
		
		System.out.println("현재속도: " + car1.speed + "km/h");
		
	}

}