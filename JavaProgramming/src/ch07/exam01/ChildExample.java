package ch07.exam01;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child(); // �θ� ��ü�� ���ÿ� ������.
		System.out.println(child.lastName+child.firstName);
		child.sound();
		child.play();
	}
}