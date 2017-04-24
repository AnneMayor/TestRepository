package ch10.exam05;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ�: " + account.getBalance());
		account.deposit(300000);
		System.out.println("�ܰ�: " + account.getBalance());
		try {
		account.withdraw(3000000);
		} catch(BalanceInsufficientException e) {
			System.out.println(e.getMessage());
		}
	}
}