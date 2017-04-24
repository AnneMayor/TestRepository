package ch11.exam03;

import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		
		Key k1 = new Key(10);
		Member m1 = new Member("Blue");
		hashMap.put(k1, m1);
		
		Key k2 = new Key(10);
		Member m2 = new Member("White");
		hashMap.put(k2, m2);
		
		System.out.println(hashMap.size());

	}
}
  