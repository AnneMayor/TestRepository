package ch14_practice.exam09;

import java.util.function.IntBinaryOperator;

public class LambdaExample05 {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}

		return result;
	}

	public static void main(String... args) {
		int max = maxOrMin((a, b) -> {
			if(a > b) {
				return a;
			} else
				return b;
		});
		System.out.println("�ִ밪: " + max);
		
		int min = maxOrMin((a, b) -> {
			if(a < b) {
				return a;
			} else
				return b;
		});
		System.out.println("�ּҰ�: " + min);
	}
}
