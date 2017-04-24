package ch12.exam06;

public class ThreadB extends Thread {
	// Field

	private boolean stop;// 스레드를 종료하기 위한 목적
	private boolean work = true;// 스레드 작업을 양보할 목적
	// Constructor

	// Method

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				System.out.println("ThreadB 작업중...");
			} else {
				yield();
			}
		}
		System.out.println("ThreadB 작업 종료...");
	}

	// private 접근 제한자이기에 외부에서 값을 변환시켜주기위한 용도로 메소드 사용
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
}