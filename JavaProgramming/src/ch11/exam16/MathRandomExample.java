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
		int num2 = random.nextInt(maxNum)+1;// nextInt() �޼ҵ忡�� ���� �Ű������� maxNum�� �־����� ������ ������ ���, ����, 0 �� ������.
		System.out.println(num2);
	}
}