package ch07.exam09;

public class Car {
	private Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void run() {
		tire.roll();
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
}
