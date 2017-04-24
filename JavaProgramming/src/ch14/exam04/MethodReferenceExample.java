package ch14.exam04;

public class MethodReferenceExample {

	public static void main(String[] args) {
		method1(new FunctionalInterface1() {
			public int method(int a, int b) {
				return Math.max(a, b);
			}
		});
		method1( Math :: min ); // �Ű����� ���� �޼ҵ带 �����ϴµ� �����Ϸ����� �� �޼ҵ带 �����϶�� �˷��ִ� ����. ���� �����Ϸ��� �ڵ����� �Ű����� ã�� �־���.
		
		method1( Math :: max);
		
		
		method1(new FunctionalInterface1() {
			public int method(int a, int b) {
				return Calculator.staticMulti(a, b);
			}
		});
		
		method1 (new FunctionalInterface1() {
			public int method(int a, int b) {
				return Calculator.staticsum(a, b);
			}
		});
		
		
		Calculator calc = new Calculator();
		method1 ( new FunctionalInterface1() {
			public int method(int a, int b) {
				return calc.minus(a, b);
			}
		});
		method1((a, b) -> calc.minus(a, b));
		method1((a, b) -> { return calc.minus(a, b); });
		
		
		method1( (a, b) -> { return Calculator.staticsum(a, b); } );
		method1( Calculator :: staticsum);
		
		
		method1((a, b) -> {
			return Calculator.staticMulti(a, b);
		});
		method1((a,b) -> Calculator.staticMulti(a, b));
		
		method1(Calculator :: staticMulti);
	}
	
	public static void method1(FunctionalInterface1 i) {
		int result = i.method(7, 14);
		System.out.println(result);
	}
}