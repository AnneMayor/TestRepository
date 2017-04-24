package exam03;

public class CalculatorExample {

	public static void main(String[] args) {
		 Calculator calc = new Calculator();
		 
		 calc.powOn();//일반적으로 메소드 호출이라고 함.
		 System.out.println(); 
		 
		 String s1 = calc.info();//return하는 변수를 받기 위하여!
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
		 
		 System.out.println(); //개행의 목적
		 
		 Car c1 = calc.makeCar("black", false);
		 System.out.println(c1.color);
		 System.out.println(c1.airbag);
		 
		 
		 

	}

}
