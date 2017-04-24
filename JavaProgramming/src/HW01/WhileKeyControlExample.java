package HW01;

public class WhileKeyControlExample {

	public static void main(String[] args) throws Exception{
		int speed = 0; //speed는 왜...?
		boolean run = true;
		int keyCode = 0;
		
		while(run) {
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("----------------------------------");
				System.out.println("1. 종속 | 2. 저장 | 3. 중지");
				System.out.println("----------------------------------");
				System.out.println("선택: ");
			}
			
			keyCode = System.in.read();
			
			//얘는 교수님이랑 같이 했던거 기억!
			
			if(keyCode == 49) {
				speed++;
				System.out.println("현재 속도: " + speed);
			} else if(keyCode == 50) {
				speed--;
				System.out.println("현재 속도: " + speed);
			} else if(keyCode == 51) {
				//while문 끝내려면 boolean변수 필요.
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}

}
