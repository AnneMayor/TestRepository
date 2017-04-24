package ch05.exam02;

public class ArrayExample02 {
	public static void main(String[] args) {
		int[] v2 = {10, 20, 30}; //배열을 보고 길이 측정하여 배열 생성.
		int[] v1 = new int[] {10,20,30}; //이건 뭐 답 없다...걍 문법으로 받아들여라!
		/*v1 = { 80, 90, 87 }; 컴파일러는 배열길이를 먼저 알고 배열생성. 만약 이렇게 선언하면
		 *  컴파일 에러. 배열을 선언하고 값을 할당시킬 수는 없음.
		 */
		int result1 = sum(v1);
		int result2 = sum(v2);
		int result3 = sum(new int[] {10, 20, 30});
		//sum( {10, 20, 30}); 이것도 앞에 주석 처리한 원리와 동일.함수에서 참조 변수 선언을 먼저 하고 배열을 그 다음에 대입시킬 순 없음! 
		//배열의 길이를 알 수 있는 배열만 배열변수로 선언하여 객체를 참조할 수 있음.
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		}
	public static int sum(int[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i++) {
			sum += args[i]; //이건 연산자 1개! sum = sum + args[i] 얘는 연산자 2개. 원래 연산자 수가 적은게 더 빠르나 이건 컴파일러 성능에 따라 속도가 다름.
			//JAVA는 컴파일러가 위의 표현을 모두 sum += args[i]로 인식. 따라서, 속도 차이 없음...
		}
		
		return sum;
	}
}
