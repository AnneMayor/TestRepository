package ch12.exam08;

public class WaitNotifyExample {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ReadThread t1 = new ReadThread(dataBox);
		WriteThread t2 = new WriteThread(dataBox);
		
		t1.start();
		t2.start();
	}

}
