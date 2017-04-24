package ch07.exam08;

public class Car {
	private Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void run() {
		tire.roll();
		// SnowTire1 snowTire = (SnowTire1) tire;
		// snowTire1.notSlide();
		
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
}
