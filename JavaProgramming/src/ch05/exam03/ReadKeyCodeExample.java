package ch05.exam03;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------------------------------------------------------------");// ln:
																									// line
																									// 이동
		System.out.println("1. 저장 | 2. 읽기 | 3. 종료");
		System.out.println("-------------------------------------------------------------------");
		int keycode = 0; //enter키도 인식.
		
		while (true) {
			if(keycode != 10 && keycode != 13) {
				System.out.print("번호선택: ");
			}
			keycode = System.in.read();
			switch (keycode) {
			case 49:
				System.out.println("저장을 선택하셨습니다.");
				break;
			case 50:
				System.out.println("읽기를 선택하셨습니다.");
				break;
			case 51:
				System.out.println("종료를 선택하셨습니다.");
				//return;//이 다음에는 코드 오면 ㄴㄴ!
				System.exit(0);//즉시, JVM종류 시킨다.
			}
			// System.out.println(keycode);
		}
	}
}
// JAVA기본 출력장치: 콘솔(모니터), 기본 입력장치: 키보드
//enter키는 두 번의 입력값을 발생시킴.(10, 13번) -> carriage return, line pid 구식 타자기의 원리에서 유래.