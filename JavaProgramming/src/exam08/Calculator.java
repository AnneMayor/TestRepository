package exam08;

public class Calculator {
	private static Calculator singleton = new Calculator();	//singleton�ȿ��� Calculator() ��ü ������ �����.
	// Field
	
	// Constructor
	private Calculator() {
	}// ��ü ������ �� ���� �����ϱ� ���ؼ� private�� ����.
	
	static Calculator getInstance() {
		return singleton;
	}//CalculatorExample Ŭ�������� private Calculator() ��ü�� �����ϱ� ���ؼ� static �޼ҵ� ��������.

	// Method

}
