package ch12.exam08;

public class ReadThread extends Thread {
	// Field
	private DataBox databox;
	// Constructor
	public ReadThread(DataBox dataBox) {
		this.databox = dataBox;// 생성자주입방식
	}
	// Method
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			String data = databox.getData();
			
		}
	}
}