package exam04;

public class Tire {
	//Field
	String direction;
	
	//Constructor
	Tire(String direction) {
		this.direction = direction;
	}
	//���⼭ �����Ϸ��� �츮�� �ϳ��� ������  ������ �ڵ����� �⺻������ ��������� ����.
	
	//Method
	void roll() {
		System.out.println(direction + "������ ���ư�");	
	}
}
