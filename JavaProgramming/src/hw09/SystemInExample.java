package hw09;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {

	public static void main(String[] args) throws IOException {
		System.out.println("== �޴� ==");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		
		// System.in �� ����Ÿ���� InputStream�̹Ƿ� InputStream�� ���� ������ ����� ������.
		InputStream is = System.in;
		// InputStream������ ����Ʈ ������ �����Ƿ� 1����Ʈ�� �о� �̸� ���ڷ� ����ȯ.
		char inputChar = (char) is.read();
		switch(inputChar) {
		case '1':
			System.out.println("���");
			break;
		case '2':
			System.out.println("�Ա�");
			break;
		case '3':
			System.out.println("����");
			break;
			default: 
				System.out.println("����Ʈ");
		}
	}
}
