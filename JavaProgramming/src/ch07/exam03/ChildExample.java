package ch07.exam03;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child("��", "ȫ��");
		System.out.println(child.lastName+child.firstName);
		child.sound();
		child.play();
	} 
}
