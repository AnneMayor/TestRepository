package ch12.exam05;

public class TargetThread extends Thread {	
	public void run() {
		for(long i=0; i<1000000000; i++) {} // �����尡 10��� ���ƾ� �ϴ°� �ƴ϶� ��ǻ�� CPU���ɿ� ���� �ٸ�
		
		try {
			//1.5�ʰ� �Ͻ� ����
			Thread.sleep(1500);
		} catch(Exception e) {}
		
		for(long i=0; i<1000000000; i++) {}
	}
}