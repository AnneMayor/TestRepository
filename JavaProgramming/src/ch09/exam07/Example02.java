package ch09.exam07;

public class Example02 {

	public static void main(String[] args) {
		// local class �����ϰ� ��ü ����

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
		
		A.C c = new A.C() { // C �������̽��� ������ ��ü �ϳ��� ���� C �������̽��� �� ��ü�� �����Ѵ�.
			@Override
			public void cMethod() {
				System.out.println("CImpl-cMethod()");
			}
		};

	}
}
