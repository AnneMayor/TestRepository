package ch14_practice.exam07;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		// function은 API문서에 따르면 이미 함수적 인터페이스임.
		function = (x, y) -> x.compareToIgnoreCase(y);
		print(function.applyAsInt("Java", "Java"));
		
		function = String::compareToIgnoreCase;
		print(function.applyAsInt("Java8", "Javo8"));
	}
	
	public static void print(int order){
		if(order < 0) {
			System.out.println("사전순으로 먼저 옵니다.");
		} else if(order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
	}
}