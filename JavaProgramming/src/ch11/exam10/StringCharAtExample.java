package ch11.exam10;

public class StringCharAtExample {
	public static void main(String[] args) {
		String name = "930812-2948133";
		
		/*
		if (name.charAt(7) == '2') {
			System.out.println("여자입니다");
		} else {
			System.out.println("남자입니다");
		}
		*/
		
		switch (name.charAt(7)) {
		case '1':
			System.out.println("남자입니다");
			break;
		case '2':
			System.out.println("여자입니다");
			break;
		}
	}
}