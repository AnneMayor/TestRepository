package hw03;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		driver.run(new Vehicle());
		driver.run(new Bus());	
	}
}