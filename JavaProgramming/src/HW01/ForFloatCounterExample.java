package HW01;

public class ForFloatCounterExample {

	public static void main(String[] args) {
		for(float x = 0.1f; x <= 1; x += 0.1f) {
			System.out.println(x);
		}
	}
	
	//이런 식으론 사용하면 안됨.결과적으로 9번밖에 시행안됨.

}
