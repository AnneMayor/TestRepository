package ch09.exam03;

public class A {
	// Field
	// Constructor
	A() {
		int localVariable = 2;
		// local class
		class D {
			// Field
			// Constructor
			// Method
			void dMethod() {
				int result = localVariable + 8;
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
			}
		}
	}                                                                                                                                                               
}