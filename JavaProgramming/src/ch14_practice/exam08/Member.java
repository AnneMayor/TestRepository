package ch14_practice.exam08;

public class Member {
	private String name;
	private String id;
	
	public Member() {
		System.out.println("Member() 시행");
	}
	
	public Member(String name) {
		System.out.println("Member(String name) 시행");
		this.name = name;
	}
	
	public Member(String name, String id) {
		System.out.println("Member(String name, String id)");
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
