package ch05.exam01;

public class CompareValueExample {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 10;
		System.out.println(v1 == v2);//v1�� v2�� ���� ������
		
		int[] v3 = { 10 };
		int[] v4 = { 10 };
		System.out.println(v3 == v4); //v3�� v4�� ���� �迭�� �����ϰ� �ִ���(���� ���� �迭�̶� ������ �ٸ��� ���ο� �迭�� �����Ǿ� �޸𸮰� �޶��� �� ����.
		
		String v5 = new String("Java");//�̷� ������� ���� �� ��. String v5 = "JAVA";�̰� ����.
		String v6 = new String("Java");//'new' = ��ü�� ���Ӱ� �����ϴ� ��ɾ�
		System.out.println(v5 == v6);//�� ��ɾ�� ö���� ��ü�� �������� ��. �� �� ������ ��������...�� �˰��� ���ο��� �̷����� ���Ĺ������� �˾Ҵ�...
		//String�� ��Ư�� ���. ������ ��ü���� new��� ��ɾ �Ἥ ������ ��ü ����.
		
		String v7 = "JAVA";
		String v8 = new String("JAVA");
		System.out.println(v7.equals(v8));//�̰� ��ü �ȿ� �ִ� ���ڿ��� �������� ���ϴ� ��ɾ�
		
		String v9 = "JAVA";
		String v10 = new String("JAVA");
		System.out.println(v9 == v10);
		
	}

}
