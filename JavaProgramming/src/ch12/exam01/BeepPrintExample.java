package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		/*
		 * Beeptask beeptask = new BeepTask(); Thread thread = new
		 * Thread(beeptask); thread.start();
		 */
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(500);	
					} catch(InterruptedException e) {
						
					}
				}
			}
		});
		thread.start();
		
		// 프린트 하는 코드
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

}
