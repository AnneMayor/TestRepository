package ch15.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		students[0] = new Student("s1");
		students[1] = new Student("s2");
		students[2] = new Student("s3");
		
		List<Student> list = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			list.add(new Student("s" + i));
		}
	}
}