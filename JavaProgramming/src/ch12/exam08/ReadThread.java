package ch12.exam08;

public class ReadThread extends Thread {
	// Field
	private DataBox databox;
	// Constructor
	public ReadThread(DataBox dataBox) {
		this.databox = dataBox;// ���������Թ��
	}
	// Method
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			String data = databox.getData();
			
		}
	}
}