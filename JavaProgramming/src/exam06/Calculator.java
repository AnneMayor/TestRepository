package exam06;

public class Calculator {
	// Field
	static String model = "MI-84";
	static String makeDay = "2017.03.29";
	static String info; //MI-84(2017.03.29)
	//
	// Constructor
	
	// Method
	void method1() {
		System.out.println("method1()"); // ���� field1, field2 �� ���� -> ȿ������ �ڵ� �ۼ��� ���� static ���̴� ��� �˱�
	}
	static void  method2() {
		System.out.println("method2()");
	}
	
	// static block
	static {
		info = model;
		info += "(";
		info += makeDay;
		info += ")";		

	}

}
