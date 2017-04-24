package hw03;

public class Car {
	Tire[] tire = { new Tire("앞왼쪽", 6), new Tire("앞오른쪽", 2), new Tire("뒤왼쪽", 3), new Tire("뒤오른쪽", 4) };

	int run() {
		System.out.println("차량이 달립니다");
		
		for(int i = 0; i < tire.length; i++) {
			if(tire[i].roll() == false) {
				stop();
				return i+1;
			}
		}
		
		return 0;
	}

	void stop() {
		System.out.println("차량이 멈춥니다");
	}
}