package ch09.exam06;

public class A {
	// Field
	int field;
	// Constructor
	// Method
	
	// Nested Interface
	interface B {
		void method();
		// field = 10; -> 얜 절대 안됨. 상수라 이건 말도 안된다...
	} // A를 떠나서는 B는 의미가 없다. A가 생성자로 객체 생성되어야 B 접근 가능.
	
}
