package ch12.exam09;

public class PrintThread2 extends Thread {
	// Field
	private boolean stop;
	
	// Constructor

	
	// Method

	@Override
	public void run() {
		try {
			while (!stop) {
				System.out.println("���� ��...");
				System.out.println("���� ��...");
				if(isInterrupted()) { // main �޼ҵ忡�� interrupted() �޼ҵ� ȣ�� Ȯ��. ���⿡ Thread.interrupted() �ᵵ �ǳ� ���� ������ �ٱ����� ����� ��쿣 Thread.interrupted() ȣ���ؾ� ��.
					break;
				}
			}
		} catch(Exception e) {
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}