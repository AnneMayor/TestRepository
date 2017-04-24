package exam04;

public class Car {

	// Field
	Body body = new Body();
	Engine engine = new Engine();
	Dashboard dashboard = new Dashboard();
	// Seat[] seat = new Seat[4]; -> seat��ü ��ü�� ����� �ƴ�. seat��ü�� ������ �迭�� ����.
	Seat[] seats = { new Seat(), new Seat(), new Seat(), new Seat() };// ...������ �ȵ� ����...���...
	Tire[] tires = { new Tire("�վ�"), new Tire("�յ�"), new Tire("�ڵ�"), new Tire("�ھ�") };
	String makeDay;
	String color;
	int speed; //���÷� �ٲ�� ����.

	// Constructor
	Car(String makeDay, String color) { //String�������� �ƹ��͵� ���Ե��� �ʾҴ�. �׷��� ���!
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
