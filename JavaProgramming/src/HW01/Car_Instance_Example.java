package HW01;

public class Car_Instance_Example {

	public static void main(String[] args) {
		Car_Instance car = new Car_Instance("������");
		Car_Instance ben = new Car_Instance("����");
		
		car.setSpeed(10);
		
		car.run();
		
		ben.setSpeed(10);
		
		ben.run();
	}

}
