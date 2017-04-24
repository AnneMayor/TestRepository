package ch10.exam04;

import java.io.IOException;

public class ThrowsExample {

	public static void main(String[] args) {

		try {
			Class.forName("");
			System.in.read();
		} catch (Exception e) {

		}
		try {
		divide(10, 9);
		} catch(ArithmeticException e) {
			System.out.println("다시 입력하시오");
		}
	}

	static void divide(int x, int y) throws ArithmeticException {
		int result = x / y;
	}
}