package exam01;

public class CarExample {

	public static void main(String[] args) {
		//��ü ���� �ڵ�
		Car c1 = new Car();//new ������ �����ڰ� ��. �� �����ڸ� ����ϱ� ���ؼ� ��ġ������ �Ҵ����־���.
		
		//��ü �޼ҵ� ȣ��
		c1.run();
		
		//��ü �ʵ尪 �б�
		System.out.println(c1.company);//��ü �ʵ�� �����ϴ� ���
		System.out.println(c1.speed);//���� �������� �ʾƵ� �̹� ��ü���� ������ �޸𸮿� �����Ǿ�����.
		//��ü�� �����Ǹ鼭 �ڵ����� �ʵ尡 ����.�̰��� ������ �ٸ� ��.
		System.out.println(c1.color);
		System.out.println(c1.airbag); //�迭�� ��ü!
		
		c1.speed = 100;//������ ���� �������־�� �� �� �ڵ忡 ��ȯ�� �����.
		c1.run();
		c1.color ="White";
		System.out.println(c1.color);
		
		/*----------------------------------------------------------------------------------------------------------*/
		
		Car c2 = new Car();
		System.out.println(c2.company);
		System.out.println(c2.speed);
		System.out.println(c2.color);
		System.out.println(c2.airbag);
		//��ü�� �ٸ��� �����Ͱ� �ٸ��� �����. ���赵�� Ŭ���� �ʱⰪ�� ���⼱ ��µȴ�.
	}

}
