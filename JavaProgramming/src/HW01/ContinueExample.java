package HW01;

public class ContinueExample {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
//짝수만 출력하는 코드군...흠...continue가 요렇게도 활용되는거에 주의!
}
