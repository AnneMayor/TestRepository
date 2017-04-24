package ch09.exam05;

public class A {
	// Field

	// Constructor
	A() {
		// local class
		class D {}
		D d = new D();
	} // A 생성자가 끝날 때까진 사용 가능. 그 이후엔 사용 불가.

	// Method

	void method() {
		// local class
		class E {}
		E e = new E();
	}
	
	//중첩 멤버 클래스
	// Nested Class
	class B {

	} // A 생성자 없인 접근할 수 없음.
	
	static class C {
		
	} // A 생성자 없이 클래스 이름만으로 접근 가능.

}
