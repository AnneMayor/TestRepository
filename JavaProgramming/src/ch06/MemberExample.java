package ch06;

import java.util.Scanner;

public class MemberExample {

	public static void main(String[] args) throws Exception {
		Member[] members = new Member[100];
		Scanner scanner = new Scanner(System.in);
		/*
		 * //while(true) { Scanner scanner = new Scanner(System.in); // �ؼ�:
		 * scanner��� ���������� �����Ͽ� �ű�� ��ü�� �Ҵ�. // �����ڴ� ��ü�� ���� ���� ����. ��ü�� �����������
		 * �����ڴ� �� �ȿ� ��. String str = scanner.nextLine();
		 * System.out.println(str);
		 * 
		 * int num = scanner.nextInt(); System.out.println(num); //}
		 */

		while (true) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1. ȸ������ | 5. ����");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("����: ");
			String strNum = scanner.nextLine();

			if (strNum.equals("1")) {
				String name = scanner.nextLine();
				int age = Integer.parseInt(scanner.nextLine());
				Member member = new Member(name, age);
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member;
						break;
					}
				}
			} else if (strNum.equals("5")) {
				System.exit(0);
			}
		}
	}
}