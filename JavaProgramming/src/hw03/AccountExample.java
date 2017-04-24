package hw03;

import java.util.Scanner;

public class AccountExample {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");
			
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
			System.out.println("프로그램 종료");
		}
	}

	private static void createAccount() {
		System.out.println("---------------------------------------------------------");
		System.out.println("계좌생성");
		System.out.println("---------------------------------------------------------");
		System.out.print("계좌번호: ");
		String accountNo = scanner.next();
		System.out.print("계좌주: ");
		String accontOwn = scanner.next();
		System.out.print("초기입금액: ");
		Integer.parseInt(scanner.next());
		System.out.println("결과: 계좌가 생성되었습니다.");
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