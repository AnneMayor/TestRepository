package ch07.exam07;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car(new SnowTire()); // �̷� �ڵ嵵 �ֱ�...��������!
		car.run();
		
		car.setTire(new NormalTire()); // ���Ⱑ ��ǰ��ü��...
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
		car.setTire(new SuperTire());
		car.run();
	}
}