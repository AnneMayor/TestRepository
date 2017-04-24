package ch11.exam06;

public class MemberExample {
	public static void main(String[] args) {
		for(int i = 0; i < 10000; i++) {
		Member m1 = new Member(String.valueOf(i));
		}
		System.gc();
	}
}