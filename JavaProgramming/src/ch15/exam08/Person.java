package ch15.exam08;
// 비교기능이 없는 객체! 그.렇.다.면. 비교기준을 주어 비교하게끔 만들기(comparator)
// 비교기능이 있는 것과 comparator 중 우선순위는 역시 comparator!
public class Person { // 여기 주목!

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}