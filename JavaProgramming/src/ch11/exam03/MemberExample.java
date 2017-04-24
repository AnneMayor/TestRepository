package ch11.exam03;

import java.util.HashSet;

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		
		HashSet hashSet = new HashSet();
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.println(hashSet.size());
	}
}