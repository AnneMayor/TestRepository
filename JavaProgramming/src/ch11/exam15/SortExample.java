package ch11.exam15;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] name = { "홍길동", "박민수", "Dahye" };

		// 오름차순으로 정리
		// sort() 메소드는 compareTo() 메소드 리턴값을 기준으로 정렬함.
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));

		// 내림차순으로 정리
		Arrays.sort(name, Collections.reverseOrder());
		System.out.println(Arrays.toString(name));

		Member[] members = { new Member("홍길동", 15), new Member("박민수", 18), new Member("Dahye", 20) };
		// Comparable com = new Member("홍길동"); -> member가 상속하거나 구현해야함.

		Arrays.sort(members);
		System.out.println(Arrays.toString(members));

		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
	}
}