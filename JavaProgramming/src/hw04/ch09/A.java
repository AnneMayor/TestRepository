package hw04.ch09;

public class A {
	
	B field1 = new B();
	C field2 = new C();
	
	void method01() {
		B var1 = new B();
		// C var2 = new C();
	}
	
	// static B field3 = new B();
	static C field4 = new C();
	
	static void method2() {
		// B var1 = new B();
		C var2 = new C();
	}
	
	A() {
		System.out.println("A 按眉啊 积己凳");
	}

	class B {
		B() {
			System.out.println("B 按眉啊 积己凳");
		}

		int field1;

		void method01() {

		}
	}

	static class C {
		C() {
			System.out.println("C 按眉啊 积己凳");
		}

		int field1;
		static int field2;

		void method01() {

		}

		static void method02() {

		}
	}

	void method() {
		class D {
			D() {
				System.out.println("D 按眉啊 积己凳");
			}
			int field1;
			void method01(){
				
			}
		}
		
		D d = new D();
		d.field1 = 3;
		d.method01();

	}

}
