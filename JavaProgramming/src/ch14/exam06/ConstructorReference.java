package ch14.exam06;

public class ConstructorReference {
	public static void main(String[] args) {
		 createMember(new FunctionalInterface() {
			 public Member createMember(String mid, String mname) {
				 return new Member(mid, mname);
			 }
		 });
		 
		 createMember((mid, mname) -> { return new Member(mid, mname); });
		 createMember((mid, mname) -> new Member(mid, mname));
		 createMember(Member :: new); // 생성자참조!
	}
	
	public static void createMember(FunctionalInterface i) {
		Member member = i.createMember("white", "Dahye Lee");
	}
}