package hw03;

import java.util.Scanner;

public class AccountExample {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("-------------------------------------------------");
			System.out.print("����> ");
			
			int selecNo = scanner.nextInt();
			
			switch(selecNo) {
			case 1:
				createAccount();
			case 2:
				accountList();
			case 3:
				deposit();
			case 4:
				withdraw();
			case 5:
				run = false;
			}
			System.out.println("���α׷� ����");
		}
	}

	private static void createAccount() {
		System.out.println("---------------------------------------------------------");
		System.out.println("���»���");
		System.out.println("---------------------------------------------------------");
		System.out.print("���¹�ȣ: ");
		String accountNo = scanner.next();
		System.out.print("������: ");
		String accontOwn = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		Integer.parseInt(scanner.next());
		System.out.println("���: ���°� �����Ǿ����ϴ�.");
	}
	
	private static void accountList() {
		
	}	
	private static void deposit() {
		
	}
	private static void withdraw() {
		
	}
	//private static Account findAccount(String ano) {
		
	//}
}