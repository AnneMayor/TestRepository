package ch14.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LambdaExpressionExample {

	private static List<Student> list = Arrays.asList(
			new Student("È«±æµ¿", 90, 96),
			new Student("±èÀÚ¹Ù", 95, 93)

	);

	public static void main(String[] args) {
		printString(s -> s.getName());
		printInt(s -> s.getEnglishScore());

	}
	
	public static void printString(Function<Student, String> function) {
		for(Student student: list) {
			System.out.print(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function) {
		for(Student student : list) {
			System.out.println(function.applyAsInt(student));
		}
	}

}
