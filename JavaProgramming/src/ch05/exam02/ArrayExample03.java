package ch05.exam02;

public class ArrayExample03 {
	public static void main(String[] args) {
		int[] v1 = new int[5];//배열항목의 값은 존재하나 디폴트 값으로 존재하는 배열변수 선언 및 배열 할당
		
		double[] v2 = new double[5];
		boolean[] v3 = new boolean[5];
		String[] v4 = new String[5];//얘는 무조건 교재 참고해서 이해하자!
		
		System.out.println("--------------------------------------------------------------------------");
		
		int[] s1 = new int[5];
		s1[0] = 10;
		s1[1] = 10;
		
		String[] s2 = new String[5];
		s2[0] = new String("JAVA");
		s2[2] = new String("JAVA");
		
		System.out.println(s1[0] == s1[1]);
		System.out.println(s2[0] == s2[2]);//String 객체 비교
		System.out.println(s2[0].equals(s2[2]));//String 문자열 비교
		
		
		
		for(int i = 0; i < v1.length; i++) {
			System.out.println("v1[" + i + "]" +" = " + v1[i]);
			System.out.println(v2[i]);
			System.out.println(v3[i]);
			System.out.println(v4[i]);
		}
		
	}
}
