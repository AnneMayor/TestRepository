package ch09.exam02;

public class A {
	// Field
	int aField;
	// Constructor
	A() {
		// local class
		class D {
			// Field
			// Constructor
			// Method
			void dMethod() {
				aField = 10;
			}
		}
	} // A �����ڰ� ���� ������ ��� ����. �� ���Ŀ� ��� �Ұ�.

	// Method

	void amethod() {
		// local class
		class E {
			
			// Field
			// Constructor
			// Method
			void eMethod() {
				aField = 10;
			}
		}
	}
	
	//��ø ��� Ŭ����
	// Nested Class
	class B {
		
		// Field
		// Constructor
		// Method
		void bMethod() {
			aField = 10;
		}

	} // A ������ ���� ������ �� ����.
	
	static class C {
		

	} // A ������ ���� Ŭ���� �̸������� ���� ����.

}
