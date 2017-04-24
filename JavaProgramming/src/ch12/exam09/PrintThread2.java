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
				System.out.println("실행 중...");
				System.out.println("실행 중...");
				if(isInterrupted()) { // main 메소드에서 interrupted() 메소드 호출 확인. 여기에 Thread.interrupted() 써도 되나 만약 스레드 바깥에서 써야할 경우엔 Thread.interrupted() 호출해야 함.
					break;
				}
			}
		} catch(Exception e) {
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}