package ch08.exam01;

public class ManualExample {

	public static void main(String[] args) {
		Manual manual = new Bike(); // Manual은 인터페이스지 실행부가 아님. 그러니 manual 참조필드에 Bike객체 주소 할당해줘야 함.
		Manual ma = new Car();
		
		manual.turnOn();
		manual.setSpeed(10);
		manual.run();
		manual.turnOff();
		move(new Bike());
		move(new Car());
	}
	
	public static void move(Manual manual) {
		manual.turnOn();
		manual.setSpeed(10);
		manual.run();
		manual.turnOff();
	}
}