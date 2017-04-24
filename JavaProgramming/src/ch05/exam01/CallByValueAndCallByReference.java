package ch05.exam01;

public class CallByValueAndCallByReference {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 20;
		int result1 = sum(v1, v2);//���� ����ϰڴٴ� �ǹ�
		System.out.println("v1:" + v1 + " v2: " + v2); //C���� ����X. ���ڿ� '+'������ ������ ���ڿ��� ��ȯ
		//'+'�� ���: 1. ��� 2. ���ڿ� ����
		//�⺻���� ���, �� ��ü�� �����.
		System.out.println("result: " + result1);
		
		int[] v4 = { 10, 20 };
		int v5 = sum(v4);
		System.out.println("v4[0]: " + v4[0] + " v4[1]: " + v4[1]);
		System.out.println("v5: " + v5);
	}
	
	public static int sum(int x, int y) {
		x = 30;
		y = 40;
		return (x+y);
	}
	
	public static int sum(int[] scores) {
		int sum = 0;
		scores[0] = 30;
		scores[1] = 40;
		for(int i = 0; i < scores.length; i++){
			sum += scores[i];
		}
		return sum;
	}
}
