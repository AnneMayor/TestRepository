package ch12.exam03;

public class CalcThread extends Thread {
	CalcThread(String name) {
		setName(name);
	}
	
	public void run() {
		for(int i = 0; i < 2000000000; i++) {
			
		}
		System.out.println(getName());
	}

}
