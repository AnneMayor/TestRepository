package exam03;

//import exam02.Car; -> '가지고 와라'
public class Calculator {
	//Field
	
	//Constructor
	//Method
	void powOn() {
		System.out.println("power on");
	}
	void powOff() {
		System.out.println("power on");
	}
	int add(int a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}
	
	double div(double x, double y) {
		return x/y;
	}

	String info() {
		return "삼성전자-2017-03-28";
	}
	int[] changeArray(int x, int y, int z) {
		int[] result = {x, y, z};
		return result;
	}
	Car makeCar(String color, boolean airbag) {
		Car c1 = new Car(color, airbag);
		return c1;//이 명령어의 의미: Car를 만든 번지값을 리턴.
	}//같은 패키지 안에 클래스 존재하면 import할 필요 없음! ctr + shift + 5 = import 입력없이 클래스 선택 가능
	
}
