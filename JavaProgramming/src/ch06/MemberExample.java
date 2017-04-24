package ch06;

import java.util.Scanner;

public class MemberExample {

	public static void main(String[] args) throws Exception {
		Member[] members = new Member[100];
		Scanner scanner = new Scanner(System.in);
		/*
		 * //while(true) { Scanner scanner = new Scanner(System.in); // 해석:
		 * scanner라는 참조변수를 선언하여 거기다 객체를 할당. // 생성자는 객체를 만들 때만 쓴다. 객체가 만들어졌으면
		 * 생성자는 그 안에 들어감. String str = scanner.nextLine();
		 * System.out.println(str);
		 * 
		 * int num = scanner.nextInt(); System.out.println(num); //}
		 */

		while (true) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1. 회원가입 | 5. 종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택: ");
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
