package ch11.exam10;

public class StringLengthExample {

	public static void main(String[] args) {
		String ssn = "123456-2018372";
		
		int length =  ssn.length();
		if(length == 13) {
			System.out.println("�ֹι�ȣ �ڸ��� �½��ϴ�");
		} else {
			System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�");
		}
	}
}