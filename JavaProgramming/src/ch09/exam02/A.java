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
	} // A 생성자가 끝날 때까진 사용 가능. 그 이후엔 사용 불가.

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
	
	//중첩 멤버 클래스
	// Nested Class
	class B {
		
		// Field
		// Constructor
		// Method
		void bMethod() {
			aField = 10;
		}

	} // A 생성자 없인 접근할 수 없음.
	
	static class C {
		

	} // A 생성자 없이 클래스 이름만으로 접근 가능.

}
