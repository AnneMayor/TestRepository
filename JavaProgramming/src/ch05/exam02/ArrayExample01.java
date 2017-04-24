package ch05.exam02;

public class ArrayExample01 {
	public static void main(String[] args) {
		int[] v1 = { 80, 90, 87 };
		int[] v2 = { 80, 90, 87, 70 };
		String[] v3 = {"Java", "Program"};
		System.out.println(v1 == v2);//객체가 다르니까...헷갈리지 마~!
		System.out.println(v1[0] == v2[0]);
		
		System.out.println(v1.length); //v1.length: length처럼 뒤에 괄호가 없는 것은 필드! 괄호가 있는 것은 메소드!
		System.out.println(v2.length);
		System.out.println(v3.length);
		
		System.out.println(args.length);
		
		int v4 = v1[0] + v1[1] + v1[2];
		v4 = 0;
		for(int i = 0; i <v1.length; i++) {
			v4 += v1[i];
		}
		
		System.out.println(v4);
		}
	}
