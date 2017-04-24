package ch11.exam14;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.binarySearch(num, 6));
		
		String[] str = { "Anne", "Mike", "Java" };
		System.out.println(Arrays.binarySearch(str, "Kim"));
	}

}
