package exam03;

public class CalculatorExample {

	public static void main(String[] args) {
		 Calculator calc = new Calculator();
		 
		 calc.powOn();//�Ϲ������� �޼ҵ� ȣ���̶�� ��.
		 System.out.println(); 
		 
		 String s1 = calc.info();//return�ϴ� ������ �ޱ� ���Ͽ�!
		 System.out.println(s1);
		 System.out.println(); 
		 
		 int result1 = 10;
		 int result2 = 20;
		 int plus = calc.add(result1, result2);
		 System.out.println(plus);
		 System.out.println(); 
		 
		 double div = calc.div(10.5, 5.2);
		 System.out.println(div);
		 System.out.println(); 
		 
		 int[] arr = calc.changeArray(10, 20, 30);
		 for(int value : arr) {
			 System.out.print(value + " ");
		 }
		 
		 System.out.println(); //������ ����
		 
		 Car c1 = calc.makeCar("black", false);
		 System.out.println(c1.color);
		 System.out.println(c1.airbag);
		 
		 
		 

	}

}
