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
		System.out.println("method1()"); // 여긴 field1, field2 다 가능 -> 효율적인 코드 작성을 위해 static 붙이는 방법 알기
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
