package ch12.exam07;

public class JoinExample {
	public static void main(String[] args) {
		SumThread thread = new SumThread();
		thread.start();
		
		try {
			thread.join();
		} catch(InterruptedException e) {}
		
		long result = thread.getSum(); // join문이 없으면 sum이 끝나기 전에 getSum()메소드를 호출해서 디폴트값인 0이 출력됨.
		System.out.println(result); 
	}
}