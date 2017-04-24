package exam07;

public class Calculator {
	// Field
	
	String field1 = "value1";
	static String field2 = "value2";
	
	// Constructor
	
	// Method
	void method1() {
		System.out.println("method1()"); // 여긴 field1, field2 다 가능 -> 효율적인 코드 작성을 위해 static 붙이는 방법 알기
	}
	static void  method2() {
		System.out.println("method2()");
	}

}
