package ch14_practice.exam04;

public class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 10;
		// public int outterField = 30 -> �̰� ������ ���ο� �ʵ尡 ����ǰ� ���� ���ԵǴ� ��!

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
