package ch11.exam16;

import java.util.Random;

public class MathRandomExample {

	public static void main(String[] args) {
		// how1
		double d = (Math.random()*6)+1;
		int maxNum = 6;
		System.out.println((int)d);
		
		//how2
		Random random = new Random();
		int num2 = random.nextInt(maxNum)+1;// nextInt() 메소드에서 만약 매개변수로 maxNum을 넣어주지 않으면 범위가 양수, 음수, 0 다 포함함.
		System.out.println(num2);
	}
}