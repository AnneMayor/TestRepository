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
			field = 10; // this.field = 10; -> �Ȱ��� ����
			A.this.field = 10; // Android���� ���� ���� ����!!!
		}
	}
}