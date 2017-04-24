package ch11.exam16;

public class WrapperExample {
	public static void main(String[] args) {
		int v1 = 10;
		
		Integer v2 = 10; // 10을 가지고 있는 Integer객체를 저장한다.(auto boxing)
		
		int v3 = v2; // v2가 가진 int값을 v3라는 int 기본타입 변수에 대입 (auto unboxing)
		
		method(3); // 자동 박싱 기능
		int v4 = method2(); // 자동 언박싱
		
	}
	
	public static void method(Object obj) { // Object를 상속하는 Integer 객체가 생성되어 int값 3을 가지고 대입
		System.out.println();
	}
	public static Integer method2() {
		return 1;
	}
}
