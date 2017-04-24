package ch05.exam01;

public class TypeExample01 {
	public static void main(String[] args) { // 이거 없으면 JVM이 작동X. 제일 먼저 main 메소드를 찾음.
		System.out.println("main() method run...");
		//기본 타입
		byte v1 = -128;
		byte v11 = 127;
		char v2 = 'A';
		short v3 = 10;
		int v4 = 100;
		long v5 = 9L;//왼쪽 항이 오른쪽 항보다 더 넓은 범위의 값을 저장할 수 있어야 함.
		
		//저장하고자 하는 데이터의 크기에 따라 기본타입 결정.
		
		float r1= 7.1F;
		double r2 = 4.55;
		
		
		boolean b1 = true;
		
		//참조 타입
		String name = "JAVA";
		int[] scores = { 90, 80, 85 }; //대괄호까지를 변수타입으로 계산하기에 절대 중간에 띄어쓰기 No.
		
		
	}

}
