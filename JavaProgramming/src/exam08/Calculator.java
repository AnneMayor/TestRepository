package exam08;

public class Calculator {
	private static Calculator singleton = new Calculator();	//singleton안에는 Calculator() 객체 번지가 저장됨.
	// Field
	
	// Constructor
	private Calculator() {
	}// 객체 오로지 한 개만 생성하기 위해서 private을 붙임.
	
	static Calculator getInstance() {
		return singleton;
	}//CalculatorExample 클래스에서 private Calculator() 객체를 생성하기 위해서 static 메소드 생성했음.

	// Method

}
