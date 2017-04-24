package practice;

public class WaitNotifyExample {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread thread1 = new ProducerThread(dataBox);
		ConsumerThread thread2 = new ConsumerThread(dataBox);
		
		thread1.start();
		thread2.start();
	}
}