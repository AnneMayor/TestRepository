package hw03;

public class InstanceOfExample {

	public static void me (Parent01 parent) {
		if(parent instanceof Child01) {
			Child01 child = (Child01) parent;
			System.out.println("method01-Child ��ȯ ����");
		} else
			System.out.println("method01-Child ��ȯ ����");
	}
	
	public static void me1(Parent01 parent) {
		Child01 child = (Child01) parent;
		System.out.println("method02 - Child ��ȯ ����");
	}
	
	public static void main(String[] args) {
		Parent01 parent = new Child01();
		me(parent);
		
		Parent01 parent1 = new Parent01();
		me1(parent1);
		
	}

}
