package ch15.exam02;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hong", "Lee", "Kim");
		for(String name : list) {
			System.out.println(name);
		}
		// list.add("3");
		
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		for(int value : list1) {
			System.out.println(value);
		}
		
		List<Double> list2 = Arrays.asList(1.0, 2.0, 3.0);
		for(double value : list2) {
			System.out.println(value);
		}
	}
}