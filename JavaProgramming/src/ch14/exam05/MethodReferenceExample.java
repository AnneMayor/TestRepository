package ch14.exam05;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		method1(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				return a.equals(b);
			}
		});
		
		method1((a, b) -> { return a.equals(b); });
		method1((a, b) -> a.equals(b));
		Calculator calc = new Calculator();
		// method1(calc :: equals); 앞의 객체에서 사용하는 매개변수 개수와 순서가 뒤의 메소드에 사용되는 메소드 매개변수 사용하는 개수 및 순서가 동일해야 함.
		method1(String :: equals); // 참고로 얘는 인스턴스 메소드임! 정적 메소드 아님!!명심명심 또 명심!		
	}
	
	public static void method1(FunctionalInterface1 i) {
		boolean result = i.method("4", "4");
		System.out.println(result);
	}
}