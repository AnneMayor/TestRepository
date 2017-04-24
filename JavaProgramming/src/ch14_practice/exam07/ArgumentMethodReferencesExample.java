package ch14_practice.exam07;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		// function�� API������ ������ �̹� �Լ��� �������̽���.
		function = (x, y) -> x.compareToIgnoreCase(y);
		print(function.applyAsInt("Java", "Java"));
		
		function = String::compareToIgnoreCase;
		print(function.applyAsInt("Java8", "Javo8"));
	}
	
	public static void print(int order){
		if(order < 0) {
			System.out.println("���������� ���� �ɴϴ�.");
		} else if(order == 0) {
			System.out.println("������ ���ڿ��Դϴ�.");
		} else {
			System.out.println("���������� ���߿� �ɴϴ�.");
		}
	}
}