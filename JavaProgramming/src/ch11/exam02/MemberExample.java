package ch11.exam02;

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
	}
}