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
	} // A 생성자가 끝날 때까진 사용 가능. 그 이후엔 사용 불가.

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