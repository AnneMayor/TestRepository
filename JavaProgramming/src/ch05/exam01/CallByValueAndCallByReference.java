package ch05.exam01;

public class CallByValueAndCallByReference {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 20;
		int result1 = sum(v1, v2);//값을 사용하겠다는 의미
		System.out.println("v1:" + v1 + " v2: " + v2); //C에선 존재X. 문자열 '+'연산은 정수도 문자열로 변환
		//'+'의 기능: 1. 산술 2. 문자열 결합
		//기본값의 경우, 값 자체가 복사됨.
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
