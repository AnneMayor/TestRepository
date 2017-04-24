package ch14.exam07;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		method1(() -> {return "Jessie J-Flashlight";});
		
		method2(() -> {return 100;});
	}
	
	public static void method1(Supplier<String> arg) {
		String result = arg.get();
		System.out.println(result);
	}
	
	public static void method2(IntSupplier arg) {
		int result = arg.getAsInt();
		System.out.println(result);
	}
}