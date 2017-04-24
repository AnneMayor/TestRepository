package ch07.exam01;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child(); // 부모 객체도 동시에 생성됨.
		System.out.println(child.lastName+child.firstName);
		child.sound();
		child.play();
	}
}