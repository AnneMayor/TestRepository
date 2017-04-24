package ch05.exam02;

public class MainArgumentExample {

	public static void main(String[] args) {
		if(args.length == 2) {
			String v1 = args[0];
			int intV1 = Integer.parseInt(v1);//parseInt(숫자문자열만!다른거 오면 에러!)
			String v2 = args[1];
			int intV2 = Integer.parseInt(v2);
			System.out.println(v1 + v2); //이건 문자열 결합
			System.out.println(intV1 + intV2);//이게 산술연산
			
		} else {
			System.out.println("두 개의 실행 매개값이 필요합니다.");
		}
		//패키지가 존재하므로 클래스 이름의 시작은 패키지 파일부터 시작!
		
		
	}

}
