package exam03;

//import exam02.Car; -> '������ �Ͷ�'
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
		return "�Ｚ����-2017-03-28";
	}
	int[] changeArray(int x, int y, int z) {
		int[] result = {x, y, z};
		return result;
	}
	Car makeCar(String color, boolean airbag) {
		Car c1 = new Car(color, airbag);
		return c1;//�� ��ɾ��� �ǹ�: Car�� ���� �������� ����.
	}//���� ��Ű�� �ȿ� Ŭ���� �����ϸ� import�� �ʿ� ����! ctr + shift + 5 = import �Է¾��� Ŭ���� ���� ����
	
}
