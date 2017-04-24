package hw04.ch09;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		
		A.B b = a.new B();
		b.field1 = 3;
		b.method01();
		
		A.C c = new A.C();
		c.field1 = 3;
		c.method01();
		A.C.field2 = 3;
		c.method02();
		
		a.method();
		
	}

}
