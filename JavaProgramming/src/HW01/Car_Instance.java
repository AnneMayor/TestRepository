package HW01;

public class Car_Instance {
	String model;
	int speed;
	
	Car_Instance(String model) {
		this.model = model;
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for(int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println( model + "가 달립니다" + "(시속: " + speed + "km/h)");
		}
	}

}
