package HW01;

public class BreakOutterExample {

	public static void main(String[] args) {
		Outter: for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if (lower == 'g') {
					break Outter;
				}
			}
		}
	System.out.println("프로그램 종료");
	}

}
//요거 좀 주의해서 보자!이렇게도 표현 가능하다!