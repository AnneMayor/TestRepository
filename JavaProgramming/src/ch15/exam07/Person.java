package ch15.exam07;
// 비교기능이 없는 객체! 그.렇.다.면. 비교기준을 주어 비교하게끔 만들기(comparator)
public class Person implements Comparable<Person> { // 여기 주목!

	private String name;
	private int age;

	@Override
	public int compareTo(Person o) {
		/*
		 * if( age < o.getAge()) { return -1; } else if( age == o.getAge()) {
		 * return 0; } else return 1;
		 */
		return Integer.compare(age, o.getAge()); // return Integer.compare(o.getAge(), age) -> 내림차순으로 정렬
	}

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