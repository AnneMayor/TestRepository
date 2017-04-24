package ch09.exam07;

public class Example {
	public static void main(String[] args) {
		// local class 정의하고 객체 생성

		/*
		 * class B2 extends A.B{
		 * 
		 * @Override void bMethod() { System.out.println("B2-bMethod()"); } }
		 * 
		 * A.B b2 = new B2(); b2.bMethod();
		 */

		A.B b = new A.B() { // B를 상속하는 클래스 객체 하나를 생성하여 그 안에 부모 클래스 객체를 대입.
			void bMethod() {
				System.out.println("B2-bMethod()");
			}
		}; // 익명 객체(이건 B의 자식 객체를 만들어서 대입을 한다 -> 위의 코드 간단하게 줄임.

	}
}
