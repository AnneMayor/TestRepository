package ch12.exam09;

public class InterruptExample {

	public static void main(String[] args) {
		// how1
		PrintThread1 thread1 = new PrintThread1();
		thread1.start();
		
		try {
			Thread.sleep(2000);
		} catch(Exception e) {}
		
		thread1.setStop(true);
		
		// how2
		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch(Exception e) {}
		thread2.interrupt();// ���⼱ ��� �ڵ尡 �������̱⿡ ���ܹ߻��� ���� ����. ������ �Ͻ������� �� ������ ���� ó��
	}
}