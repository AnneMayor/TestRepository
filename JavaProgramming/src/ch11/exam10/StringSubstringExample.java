package ch11.exam10;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn = "930812-2094810";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
	}
}