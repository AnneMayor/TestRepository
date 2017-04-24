package ch12.exam10;

public class DaemonExample {

	public static void main(String[] args) {
		System.out.println("워드프로세스를 시작함");
		AutoSaveThread autothread = new AutoSaveThread();
		// autothread.setDaemon(true);
		autothread.start(); // 얘는 main메소드 종료해도 자동으로 종료 안된다...
		try {
			autothread.sleep(4000);
		} catch (InterruptedException e) {
		}

		System.out.println("워드프로세스를 종료함");
	}
}