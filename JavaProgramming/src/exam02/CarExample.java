package exam02;

public class CarExample {

	public static void main(String[] args) {
		//��ü ���� �ڵ�
		Car c1 = new Car();//new ������ �����ڰ� ��. �� �����ڸ� ����ϱ� ���ؼ� ��ġ������ �Ҵ����־���.	
		//��ü �ʵ尪 �б�
		System.out.println(c1.company);//��ü �ʵ�� �����ϴ� ���
		System.out.println(c1.speed);//���� �������� �ʾƵ� �̹� ��ü���� ������ �޸𸮿� �����Ǿ�����.
		//��ü�� �����Ǹ鼭 �ڵ����� �ʵ尡 ����.�̰��� ������ �ٸ� ��.
		System.out.println(c1.color);
		System.out.println(c1.airbag); //�迭�� ��ü!
		
		Car c2 = new Car("White", true);
		System.out.println(c2.company);//��ü �ʵ�� �����ϴ� ���
		System.out.println(c2.speed);//���� �������� �ʾƵ� �̹� ��ü���� ������ �޸𸮿� �����Ǿ�����.
		//��ü�� �����Ǹ鼭 �ڵ����� �ʵ尡 ����.�̰��� ������ �ٸ� ��.
		System.out.println(c2.color);
		System.out.println(c2.airbag); //�迭�� ��ü!
		
		c2 = new Car("Blue", false);
	}

}
