package ch14.exam03;

public class LambdaExpressionExample {
	public static int a;
	
	public static void main(String[] args) {
		method1(() -> {
			a = 9;
			System.out.println(a);
		});
		
		int b = 5;
		method1(() -> {
			a = 9;
			// b = 9;
			while(true) {
				System.out.println(b);//  여기서 로컬클래스에서 배운 매개변수 및 필드 사용제한 개념 다시 등장!이거 다시 한번 체크해보기~!
			}
			// System.out.println(a);
		});
		
	}
	
	public static void method1(FunctionalInterface1 i) {
		
	}
}