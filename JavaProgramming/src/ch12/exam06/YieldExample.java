package ch12.exam06;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threada = new ThreadA();
		ThreadB threadb = new ThreadB();
		threada.start();
		threadb.start();

		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threada.setWork(false);
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threada.setWork(true);
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		
		threada.setStop(true);
		threadb.setStop(true);
	}

}
