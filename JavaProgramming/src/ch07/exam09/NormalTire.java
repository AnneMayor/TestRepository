package ch07.exam09;

public class NormalTire extends Tire {
	
	NormalTire() {
		//super();
		System.out.println("NormalTire ��ü ����");
	}
	
	@Override
	void roll() {
		System.out.println("�Ϲ� Ÿ�̾ �������ϴ�.");
	}
}
