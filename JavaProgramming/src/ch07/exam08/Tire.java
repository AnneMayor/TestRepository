package ch07.exam08;

public abstract class Tire {
	Tire tire;
	
	int diameter;
	
	
	Tire() {
		System.out.println("Tire ��ü ����");
	}
	
	abstract void roll();
	
	/*
	void roll() { ���⸦ body��� �Ѵ�.
		// �� �޼ҵ�� ���� ������ �ִ� ������ ������ Ŭ������.
		// ������ ���ص� ������ ���� �߻�X.
	}
	*/
	
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	public int getDiameter() {
		return diameter;
	}
}
