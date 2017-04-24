package ch09.exam06;

public class Example implements A.B{ // "A안에 선언된 Nested interface B를 활용하겠다"

	@Override
	public void method() {
		
	}
	public static void main(String[] args) {
		class C implements A.B {
			@Override
			public void method() {
				
			}
			
		}
		

	}

}
