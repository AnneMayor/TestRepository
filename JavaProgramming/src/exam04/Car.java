package exam04;

public class Car {

	// Field
	Body body = new Body();
	Engine engine = new Engine();
	Dashboard dashboard = new Dashboard();
	// Seat[] seat = new Seat[4]; -> seat객체 자체를 만든건 아님. seat객체를 저장할 배열을 만듦.
	Seat[] seats = { new Seat(), new Seat(), new Seat(), new Seat() };// ...응용이 안돼 나도...답답...
	Tire[] tires = { new Tire("앞앞"), new Tire("앞뒤"), new Tire("뒤뒤"), new Tire("뒤앞") };
	String makeDay;
	String color;
	int speed; //수시로 바뀌기 때문.

	// Constructor
	Car(String makeDay, String color) { //String변수에는 아무것도 대입되지 않았다. 그래서 사용!
		this.makeDay = makeDay;
		this.color = color;
	}

	// Method
	void start() {
		engine.start();
	}
	void run() {
			tires[0].roll();
			tires[1].roll();
			tires[2].roll();
			tires[3].roll();
			setSpeed(60);
			dashboard.display(60);
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	void stop() {
		engine.stop();
		speed = 0;

	}

}
