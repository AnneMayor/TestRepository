package ch12.exam05;

public class TargetThread extends Thread {	
	public void run() {
		for(long i=0; i<1000000000; i++) {} // 스레드가 10억번 돌아야 하는게 아니라 컴퓨터 CPU성능에 따라 다름
		
		try {
			//1.5초간 일시 정지
			Thread.sleep(1500);
		} catch(Exception e) {}
		
		for(long i=0; i<1000000000; i++) {}
	}
}