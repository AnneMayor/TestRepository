package exam09;

public class Member {
	
	String name;
	final String ssn; //필드값을 한번 부여받으면 절대 안바꿀거다라고 선언하는 것
	static final String NATION = "한국";
	
	
	Member(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}
