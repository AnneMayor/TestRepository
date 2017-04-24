package practice;

public class ThreadA1 extends Thread {
	// Field
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				System.out.println("ThreadA 작업 내용");
			} else {
				Thread.yield();
			}
		}
		System.out.println("ThreadA 종료");
	}
}