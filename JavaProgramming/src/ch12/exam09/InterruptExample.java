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
		thread2.interrupt();// 여기선 계속 코드가 실행중이기에 예외발생을 하지 않음. 오로지 일시정지로 갈 때에만 예외 처리
	}
}