package ch12.exam10;

public class DaemonExample {

	public static void main(String[] args) {
		System.out.println("�������μ����� ������");
		AutoSaveThread autothread = new AutoSaveThread();
		// autothread.setDaemon(true);
		autothread.start(); // ��� main�޼ҵ� �����ص� �ڵ����� ���� �ȵȴ�...
		try {
			autothread.sleep(4000);
		} catch (InterruptedException e) {
		}

		System.out.println("�������μ����� ������");
	}
}