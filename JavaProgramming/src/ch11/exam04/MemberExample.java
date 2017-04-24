package ch11.exam04;

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		System.out.println(m1.toString());
		System.out.println(m1);
		
		String result = m1 + "good!";
		System.out.println(result);
	}
}