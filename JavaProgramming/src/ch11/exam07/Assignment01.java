package ch11.exam07;

public class Assignment01 {
	int field = 10;
	void method01(int arg) {
		int field1 = 10;
		
		class A {
			int field2 = 40;
			void method02(int arg1) {
				field = 10;
				field1 = 20;
				field2 = 30;
				arg = 500;
				arg1 = 100;
			}
		}
	}
}