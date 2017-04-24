package ch05.exam01;

public class NullPointerException {

	public static void main(String[] args) {
		/*
		int[] scores = null; //배열 생성 안되었다!
		
		System.out.println(scores[0]);
       */		
		//실행할 때 발생하는 오류: 예외(컴파일 문제 X)
		
		String name = null;
		System.out.println(name.length());//'.': 참조 .객체로 접근
		
		
	}

}
