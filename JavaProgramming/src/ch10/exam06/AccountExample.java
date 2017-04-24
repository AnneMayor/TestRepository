package ch10.exam06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("¿‹∞Ì: " + account.getBalance());
		account.deposit(300000);
		System.out.println("¿‹∞Ì: " + account.getBalance());
		try {
		account.withdraw(3000000);
		} catch(BalanceInsufficientException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}