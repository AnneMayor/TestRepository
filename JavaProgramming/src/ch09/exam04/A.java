package ch09.exam04;

public class A {
	// Field
	int field;
	
	// Constructor
	
	// Method
	
	//Nested Class
	class B {
		int field;
		
		void method() {
			field = 10; // this.field = 10; -> 똑같은 내용
			A.this.field = 10; // Android에서 가장 많이 쓴다!!!
		}
	}
}