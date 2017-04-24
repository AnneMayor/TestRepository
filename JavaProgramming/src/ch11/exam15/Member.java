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
		// 유연하게 생각하자!너무 하나에만 국한되어서 시야를 넓게 보지 못하면 안된다...
		// return name.compareTo(member.name);// String이 갖고있는 compareTo()!
		return Integer.compare(age, member.age); // 아 이렇게 표현하는거구나...쯧...내가 이걸 찾으려고 그 갖은 시도를 다했건만...알아둬야지!
		
		/*
		 * if(age < member.age) { return -1;}
		 * if(age == member.age) { return 0; }
		 * return 1;
		 */
	}
}