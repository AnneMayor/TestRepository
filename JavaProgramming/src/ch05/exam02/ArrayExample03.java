package ch05.exam02;

public class ArrayExample03 {
	public static void main(String[] args) {
		int[] v1 = new int[5];//�迭�׸��� ���� �����ϳ� ����Ʈ ������ �����ϴ� �迭���� ���� �� �迭 �Ҵ�
		
		double[] v2 = new double[5];
		boolean[] v3 = new boolean[5];
		String[] v4 = new String[5];//��� ������ ���� �����ؼ� ��������!
		
		System.out.println("--------------------------------------------------------------------------");
		
		int[] s1 = new int[5];
		s1[0] = 10;
		s1[1] = 10;
		
		String[] s2 = new String[5];
		s2[0] = new String("JAVA");
		s2[2] = new String("JAVA");
		
		System.out.println(s1[0] == s1[1]);
		System.out.println(s2[0] == s2[2]);//String ��ü ��
		System.out.println(s2[0].equals(s2[2]));//String ���ڿ� ��
		
		
		
		for(int i = 0; i < v1.length; i++) {
			System.out.println("v1[" + i + "]" +" = " + v1[i]);
			System.out.println(v2[i]);
			System.out.println(v3[i]);
			System.out.println(v4[i]);
		}
		
	}
}
