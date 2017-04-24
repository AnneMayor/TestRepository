package hw04.ch09;

public class A1 {
	int field1;
	
	void method01() {
		
	}
	
	static int field2;
	static void method02() {
		
	}
	
	class B {
		void method() {
			field1 = 10;
			method01();
			
			field2 = 19;
			method02();
		}
	}
	
	static class C {
		void method() {
			// field01 = 10; -> Compile error
			// method01(); -> Compile error
			field2 = 20;
			method02();
		}
	}
}