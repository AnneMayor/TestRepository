package ch12.exam07;

public class JoinExample {
	public static void main(String[] args) {
		SumThread thread = new SumThread();
		thread.start();
		
		try {
			thread.join();
		} catch(InterruptedException e) {}
		
		long result = thread.getSum(); // join���� ������ sum�� ������ ���� getSum()�޼ҵ带 ȣ���ؼ� ����Ʈ���� 0�� ��µ�.
		System.out.println(result); 
	}
}