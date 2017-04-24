package ch11.exam13;

import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "019-25-3556";
		
		boolean result1 = Pattern.matches(regExp, data);
		if(result1) {
			System.out.println("���Խİ� ��ġ�մϴ�");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.com";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("���Խİ� ��ġ�մϴ�");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�");
		}
	}
}
