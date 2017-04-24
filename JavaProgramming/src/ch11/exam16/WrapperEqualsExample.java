package ch11.exam16;

public class WrapperEqualsExample {

	public static void main(String[] args) {
		Integer v1 = 1000;
		Integer v2 = 1000;
		
		System.out.println(v1 == v2);
		/*
		 * v1, v2 = 10; -> ���� -128 ~ 127 ���̶� ��ü �������� ����.
		 * v1, v2 = 1000; -> out of range�� ��ü �������� �ٸ�. 
		 * �׷��� ������, ������ ������ ������ equals() �޼ҵ� ���! ������ڴ� �������� �� ���� �� ������!
		 */
		// System.out.println(v1.intValue() == v2.intValue()); -> �� ����� �������!
		System.out.println(v1.equals(v2)); // String��ü�Ӹ� �ƴ϶� �ٸ� ��ü����� �񱳰� �����ϱ���
	}
}