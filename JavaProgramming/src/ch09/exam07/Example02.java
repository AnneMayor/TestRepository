package ch09.exam07;

public class Example02 {

	public static void main(String[] args) {
		// local class 정의하고 객체 생성

		/*
		 * class CImpl implements A.C {
		 * 
		 * @Override public void cMethod() {
		 * System.out.println("CImpl-cMethod()"); }
		 * 
		 * }
		 * 
		 * A.C c = new CImpl(); c.cMethod();
		 * 
		 */
		
		A.C c = new A.C() { // C 인터페이스를 구현한 객체 하나를 만들어서 C 인터페이스를 그 객체에 대입한다.
			@Override
			public void cMethod() {
				System.out.println("CImpl-cMethod()");
			}
		};

	}
}
