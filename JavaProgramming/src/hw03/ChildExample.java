package hw03;

public class ChildExample {
	public static void main(String[] args) {
		Parent parent = new Child();
		
		parent.method01();
		parent.method02();
		
		Child child = (Child) parent;
		
		child.method03();
		child.method04();
	}
}