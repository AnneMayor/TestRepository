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
				System.out.println(b);//  ���⼭ ����Ŭ�������� ��� �Ű����� �� �ʵ� ������� ���� �ٽ� ����!�̰� �ٽ� �ѹ� üũ�غ���~!
			}
			// System.out.println(a);
		});
		
	}
	
	public static void method1(FunctionalInterface1 i) {
		
	}
}