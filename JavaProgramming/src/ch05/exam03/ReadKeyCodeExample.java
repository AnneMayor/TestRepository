package ch05.exam03;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------------------------------------------------------------");// ln:
																									// line
																									// �̵�
		System.out.println("1. ���� | 2. �б� | 3. ����");
		System.out.println("-------------------------------------------------------------------");
		int keycode = 0; //enterŰ�� �ν�.
		
		while (true) {
			if(keycode != 10 && keycode != 13) {
				System.out.print("��ȣ����: ");
			}
			keycode = System.in.read();
			switch (keycode) {
			case 49:
				System.out.println("������ �����ϼ̽��ϴ�.");
				break;
			case 50:
				System.out.println("�б⸦ �����ϼ̽��ϴ�.");
				break;
			case 51:
				System.out.println("���Ḧ �����ϼ̽��ϴ�.");
				//return;//�� �������� �ڵ� ���� ����!
				System.exit(0);//���, JVM���� ��Ų��.
			}
			// System.out.println(keycode);
		}
	}
}
// JAVA�⺻ �����ġ: �ܼ�(�����), �⺻ �Է���ġ: Ű����
//enterŰ�� �� ���� �Է°��� �߻���Ŵ.(10, 13��) -> carriage return, line pid ���� Ÿ�ڱ��� �������� ����.