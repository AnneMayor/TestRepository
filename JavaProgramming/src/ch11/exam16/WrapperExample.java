package ch11.exam16;

public class WrapperExample {
	public static void main(String[] args) {
		int v1 = 10;
		
		Integer v2 = 10; // 10�� ������ �ִ� Integer��ü�� �����Ѵ�.(auto boxing)
		
		int v3 = v2; // v2�� ���� int���� v3��� int �⺻Ÿ�� ������ ���� (auto unboxing)
		
		method(3); // �ڵ� �ڽ� ���
		int v4 = method2(); // �ڵ� ��ڽ�
		
	}
	
	public static void method(Object obj) { // Object�� ����ϴ� Integer ��ü�� �����Ǿ� int�� 3�� ������ ����
		System.out.println();
	}
	public static Integer method2() {
		return 1;
	}
}
