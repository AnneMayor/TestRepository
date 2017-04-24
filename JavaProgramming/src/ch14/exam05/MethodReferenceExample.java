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
		// method1(calc :: equals); ���� ��ü���� ����ϴ� �Ű����� ������ ������ ���� �޼ҵ忡 ���Ǵ� �޼ҵ� �Ű����� ����ϴ� ���� �� ������ �����ؾ� ��.
		method1(String :: equals); // ����� ��� �ν��Ͻ� �޼ҵ���! ���� �޼ҵ� �ƴ�!!��ɸ�� �� ���!		
	}
	
	public static void method1(FunctionalInterface1 i) {
		boolean result = i.method("4", "4");
		System.out.println(result);
	}
}