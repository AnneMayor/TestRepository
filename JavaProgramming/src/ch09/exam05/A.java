package ch09.exam05;

public class A {
	// Field

	// Constructor
	A() {
		// local class
		class D {}
		D d = new D();
	} // A �����ڰ� ���� ������ ��� ����. �� ���Ŀ� ��� �Ұ�.

	// Method

	void method() {
		// local class
		class E {}
		E e = new E();
	}
	
	//��ø ��� Ŭ����
	// Nested Class
	class B {

	} // A ������ ���� ������ �� ����.
	
	static class C {
		
	} // A ������ ���� Ŭ���� �̸������� ���� ����.

}
