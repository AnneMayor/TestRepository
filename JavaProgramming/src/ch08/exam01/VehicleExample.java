package ch08.exam01;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle(new Bike());
		Vehicle vehicle1 = new Vehicle(new Car());
		
		vehicle.move();
		vehicle1.move();
	}
}