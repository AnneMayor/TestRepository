package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		String name1 = new String("Dahye Lee");
		String name2 = new String("Dahye Lee");
		
		if(name1 == name2) {
			System.out.println("���� ��ü�Դϴ�.");
		} else {
			System.out.println("�ٸ� ��ü�Դϴ�.");
		}
		
		if(name1.equals(name2)) {
			System.out.println("���� �����Դϴ�.");
		} else {
			System.out.println("�ٸ� �����Դϴ�.");
		}
	}
}