package ch11.exam02;

public class Member {
	// Field
	
	private String id;
	
	// Constructor
	public Member(String id) {
		this.id = id;
	}
	
	// Method
	
	@Override
	public boolean equals(Object obj) { // Object 객체는 자바의 모든 객체의 부모 객체
		
		if(obj instanceof Member) {
			Member target = (Member) obj;
			if(id.equals(target.id)) {
				return true;
			}
		} 
		return false;
	}	
}