package ch09.exam07;

public class Example {
	public static void main(String[] args) {
		// local class �����ϰ� ��ü ����

		/*
		 * class B2 extends A.B{
		 * 
		 * @Override void bMethod() { System.out.println("B2-bMethod()"); } }
		 * 
		 * A.B b2 = new B2(); b2.bMethod();
		 */

		A.B b = new A.B() { // B�� ����ϴ� Ŭ���� ��ü �ϳ��� �����Ͽ� �� �ȿ� �θ� Ŭ���� ��ü�� ����.
			void bMethod() {
				System.out.println("B2-bMethod()");
			}
		}; // �͸� ��ü(�̰� B�� �ڽ� ��ü�� ���� ������ �Ѵ� -> ���� �ڵ� �����ϰ� ����.

	}
}
