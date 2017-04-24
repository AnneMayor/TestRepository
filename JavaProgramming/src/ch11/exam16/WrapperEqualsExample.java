package ch11.exam16;

public class WrapperEqualsExample {

	public static void main(String[] args) {
		Integer v1 = 1000;
		Integer v2 = 1000;
		
		System.out.println(v1 == v2);
		/*
		 * v1, v2 = 10; -> 범위 -128 ~ 127 값이라 객체 번지값이 같음.
		 * v1, v2 = 1000; -> out of range라 객체 번지값이 다름. 
		 * 그래서 정하자, 무조건 값비교할 적에는 equals() 메소드 써라! 동등연산자는 절대절대 값 비교할 때 쓰지마!
		 */
		// System.out.println(v1.intValue() == v2.intValue()); -> 이 방법도 옛날방법!
		System.out.println(v1.equals(v2)); // String객체뿐만 아니라 다른 객체들과도 비교가 가능하구나
	}
}