package practice;

public class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA methodA 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB methodB 작업 실행");
		notify();
		try{
			wait();
		} catch(InterruptedException e) {}
	}
}