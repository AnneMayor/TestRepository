package ch11.exam15;

public class Member implements Comparable<Member> {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + age;
	}
	

	@Override
	public int compareTo(Member member) {
		// �����ϰ� ��������!�ʹ� �ϳ����� ���ѵǾ �þ߸� �а� ���� ���ϸ� �ȵȴ�...
		// return name.compareTo(member.name);// String�� �����ִ� compareTo()!
		return Integer.compare(age, member.age); // �� �̷��� ǥ���ϴ°ű���...��...���� �̰� ã������ �� ���� �õ��� ���߰Ǹ�...�˾Ƶ־���!
		
		/*
		 * if(age < member.age) { return -1;}
		 * if(age == member.age) { return 0; }
		 * return 1;
		 */
	}
}