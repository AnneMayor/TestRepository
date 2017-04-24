package ch11.exam03;

public class Member {
	// Field
	
	private String id;
	
	// Constructor
	public Member(String id) {
		this.id = id;
	}
	
	// Method
	
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) { // Object ��ü�� �ڹ��� ��� ��ü�� �θ� ��ü
		
		if(obj instanceof Member) {
			Member target = (Member) obj;
			if(id.equals(target.id)) {
				return true;
			}
		} 
		return false;
	}	
}