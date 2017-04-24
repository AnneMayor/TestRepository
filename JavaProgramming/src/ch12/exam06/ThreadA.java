package ch12.exam06;

public class ThreadA extends Thread {
	// Field

	private boolean stop;// �����带 �����ϱ� ���� ����
	private boolean work = true;// ������ �۾��� �纸�� ����
	// Constructor

	// Method

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				System.out.println("ThreadA �۾���...");
			} else {
				yield();
			}
		}
		System.out.println("ThreadA �۾� ����...");
	}

	// private ���� �������̱⿡ �ܺο��� ���� ��ȯ�����ֱ����� �뵵�� �޼ҵ� ���
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
}