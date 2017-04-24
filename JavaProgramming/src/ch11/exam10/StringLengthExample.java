package ch11.exam10;

public class StringLengthExample {

	public static void main(String[] args) {
		String ssn = "123456-2018372";
		
		int length =  ssn.length();
		if(length == 13) {
			System.out.println("주민번호 자리가 맞습니다");
		} else {
			System.out.println("주민번호 자리수가 틀립니다");
		}
	}
}