package ch05.exam01;

public class CompareValueExample {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 10;
		System.out.println(v1 == v2);//v1과 v2의 값은 같으냐
		
		int[] v3 = { 10 };
		int[] v4 = { 10 };
		System.out.println(v3 == v4); //v3과 v4는 같은 배열을 참조하고 있느냐(값이 같은 배열이라도 변수가 다르면 새로운 배열이 생성되어 메모리값 달라질 수 있음.
		
		String v5 = new String("Java");//이런 방식으로 거의 안 씀. String v5 = "JAVA";이게 흔함.
		String v6 = new String("Java");//'new' = 객체를 새롭게 생성하는 명령어
		System.out.println(v5 == v6);//이 명령어는 철저히 객체가 같은지를 비교. 쓸 때 굉장히 조심하자...나 알고리즘 공부에서 이래갖고 미쳐버리는줄 알았다...
		//String이 독특한 경우. 나머지 객체들은 new라는 명령어를 써서 각각의 객체 생성.
		
		String v7 = "JAVA";
		String v8 = new String("JAVA");
		System.out.println(v7.equals(v8));//이건 객체 안에 있는 문자열이 같은지를 비교하는 명령어
		
		String v9 = "JAVA";
		String v10 = new String("JAVA");
		System.out.println(v9 == v10);
		
	}

}
