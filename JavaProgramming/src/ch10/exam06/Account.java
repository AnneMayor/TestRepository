package ch10.exam06;

public class Account {

	private long balance;
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException {
		if(balance < money) {
			throw new BalanceInsufficientException("�ܰ� ����");
		}
		balance -= money;
	}
	
	public long getBalance() {
		return balance;
	}
}