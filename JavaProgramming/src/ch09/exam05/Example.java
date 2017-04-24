package ch09.exam05;

import ch07.exam05.pack2.C;

public class Example {
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); // 이런 경우는 드물다. static으로 선언한 경우가 더 많다.
		
		A.C c = new A.C(); // 이렇게 사용하는 경우가 더 많다. 그리고 코드만 보고도 A클래스 구성이 어떻게 되었는지 알기
		
		
		
		
		
	}

}
