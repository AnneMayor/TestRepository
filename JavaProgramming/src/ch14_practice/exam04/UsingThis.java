package ch14_practice.exam04;

public class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 10;
		// public int outterField = 30 -> 이건 완전히 새로운 필드가 선언되고 값이 대입되는 것!

		void method() {
			MyFunctionalInterface fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField);
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField + "\n");
			};
			fi.method();
		}
	}
}
