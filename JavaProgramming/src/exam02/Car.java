package exam02;

public class Car {
	// Field(��κ� ���� �ҹ��ڷ� ����)
	String company;// �ʵ忡�� ���� �Ҵ������� �ʾƵ� ���� ����.���� �� �ʿ�� ������ ����Ʈ ���� �ִٸ� �Ҵ�.
	int speed;
	String color;// Ư�� ���� �Ҵ��ϸ� �⺻������ ��ü ������ �� �ʿ��� �����Ͱ��̶�� ���� ��.
	boolean airbag;

	// Constructor
	Car() {
		this("Hyundae", null, false); //���� ������, ���� �Ǵٸ� �����ڸ� ȣ���ش޶�!
	}
	
	Car(String color, boolean airbag) {
		this("Hyundae", color, airbag);//�ߺ��ڵ� ����
	}
	//������ �����ε�: Ŭ���� �ȿ� �����ڸ� ���� �� ����.
	//�������̵��� ��Ӱ� ����

	Car(String company, String color, boolean airbag) {
		this.company = company;
		this.color = color;
		this.airbag = airbag;
	}
	// Method
	void run() {
		System.out.println("���� " + speed + "km/h�� ����");
	}

	void stop() {
		System.out.println("����");
		speed = 0;
	}
}
