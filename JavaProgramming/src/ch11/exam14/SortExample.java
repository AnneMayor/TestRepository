package ch11.exam14;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] name = { "홍길동", "박민수", "Dahye" };
		
		// 오름차순으로 정리
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		// 내림차순으로 정리
		Arrays.sort(name, Collections.reverseOrder());
		System.out.println(Arrays.toString(name));
	}
}