package ch05.exam01;

public class NullExample {

	public static void main(String[] args) {
		String v1 = null;
		
		String v2;//이땐 아직 생성하지 않았음.
		//v2 = null;
		
		int[] v3 = null;
		
		if( v3 == null) { //may not been initialized -> 스택에 변수 생성 안되었다!변수 사용하려면 초기화
			System.out.println("null");
		} else if( v3 != null) {
			System.out.println("not null");
		}	
	}
}