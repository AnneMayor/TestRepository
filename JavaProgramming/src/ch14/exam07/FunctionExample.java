package ch14.exam07;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

public class FunctionExample {
	public void main(String...args) {
		
		method1((d) -> (int)d);
		method1((d) -> {
			return (int)Math.round(d);
		});
		
		method2((member) -> {
			return member.getMname();
		});
	}
	
	public static void method1(DoubleToIntFunction arg) {
		int result = arg.applyAsInt(3.54);
		System.out.println(result);
	}
	
	public static void method2(Function<Member, String> arg) {
		Member member = new Member("white", "Dahye Anne Lee");
		String result = arg.apply(member);
		System.out.println(result);
	}
	
	
}