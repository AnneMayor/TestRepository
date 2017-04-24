package hw09;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {

	public static void main(String[] args) throws IOException {
		System.out.println("== 메뉴 ==");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		
		// System.in 의 리턴타입이 InputStream이므로 InputStream형 참조 변수를 만들어 대입함.
		InputStream is = System.in;
		// InputStream에서는 바이트 단위로 읽으므로 1바이트를 읽어 이를 문자로 형변환.
		char inputChar = (char) is.read();
		switch(inputChar) {
		case '1':
			System.out.println("출금");
			break;
		case '2':
			System.out.println("입금");
			break;
		case '3':
			System.out.println("통장");
			break;
			default: 
				System.out.println("디폴트");
		}
	}
}
