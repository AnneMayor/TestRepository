package ch11.exam10;

public class StringCharAtExample {
	public static void main(String[] args) {
		String name = "930812-2948133";
		
		/*
		if (name.charAt(7) == '2') {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("�����Դϴ�");
		}
		*/
		
		switch (name.charAt(7)) {
		case '1':
			System.out.println("�����Դϴ�");
			break;
		case '2':
			System.out.println("�����Դϴ�");
			break;
		}
	}
}