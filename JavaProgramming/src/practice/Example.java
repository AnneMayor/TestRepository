package practice;

public class Example {
	public static void main(String[] args) {
		ThreadA1 threadA = new ThreadA1();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		threadA.work = false;

		threadA.stop = true;
		threadB.stop = true;
	}
}
