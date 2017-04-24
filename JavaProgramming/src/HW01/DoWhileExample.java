package HW01;
import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.print(">");
			inputString = sc.nextLine();
			System.out.println(inputString);
		} while(! inputString.equals("q"));
		
		System.out.println();
		System.out.println("프로그램 종료");
	}

	//이건 정말 익숙하지않은 문법...난 for문만 써왔는데...알고리즘에선 엄청 중요하니 정신 차리자!
}
