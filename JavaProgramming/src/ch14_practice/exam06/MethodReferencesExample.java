package ch14_practice.exam06;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		operator = (x, y) -> {
			return Calculator.staticMethod(x, y);
		};
		System.out.println(operator.applyAsInt(4, 5));
		operator = Calculator::staticMethod;
		System.out.println(operator.applyAsInt(4, 5));
		
		Calculator calc = new Calculator();
		operator = (x, y) -> {return calc.instanceMethod(4, 5);};
		System.out.println(operator.applyAsInt(4, 5));
		operator = (x, y) -> calc.instanceMethod(4, 5);
		System.out.println(operator.applyAsInt(4, 5));
		operator = calc::instanceMethod;
		System.out.println(operator.applyAsInt(4, 5));	
	}
}