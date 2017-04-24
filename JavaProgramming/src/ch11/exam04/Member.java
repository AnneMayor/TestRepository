package ch11.exam04;

public class Member {
	// Field
	
	private String id;
	
	// Constructor
	public Member(String id) {
		this.id = id;
	}
	
	// Method
	
	@Override
	public String toString() {
		return id;
	}
}