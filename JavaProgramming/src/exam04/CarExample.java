package exam04;

public class CarExample {

	public static void main(String[] args) {
		Car c1 = new Car("2017-08-12", "Gray");
		
		c1.engine.start();
		c1.engine.stop();
		//Dashboard�� �޼ҵ� ȣ��
		c1.dashboard.display(60);
		//Tire�� �ʵ尪 �б�
		System.out.println(c1.tires[0].direction);
		//Tire�� �޼ҵ� ȣ��
		c1.tires[2].roll();
		//Car�� �޼ҵ� ȣ��
		c1.start();
		
		//------------------------------------------------------------------------------------------------------------
		//Tire ��ǰ ��ü -> ��ü ���� ���α׷����� �߰��� ���� ��ü�� �� ����. �װ� ����.
		c1.tires[1] = new Tire("�� �յ� Ÿ�̾�");//�̰� �� ������ �ҽ���...�� �˾Ƶ���!
		c1.run();
		
		
		
	}

}
