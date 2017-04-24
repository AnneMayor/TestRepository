package ch14_practice.exam03;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi.method(3, 5));
		
		fi = (x, y) -> { return x + y; };
		System.out.println(fi.method(3, 5));
		
		fi = (x, y) -> x + y;
		System.out.println(fi.method(3, 5));
		
		fi = (x, y) -> sum(x, y);
		System.out.println(fi.method(3, 5));
	}
	
	public static int sum(int a, int b) {
		return (a + b);
	}

}
