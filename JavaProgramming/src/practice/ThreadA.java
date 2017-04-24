package practice;

public class ThreadA extends Thread {
	private WorkObject workObject;
	
	private ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override 
	public void run() {
		for(int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}
}