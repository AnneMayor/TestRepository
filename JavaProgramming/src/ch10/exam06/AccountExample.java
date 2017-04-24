package ch10.exam06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ�: " + account.getBalance());
		account.deposit(300000);
		System.out.println("�ܰ�: " + account.getBalance());
		try {
		account.withdraw(3000000);
		} catch(BalanceInsufficientException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}