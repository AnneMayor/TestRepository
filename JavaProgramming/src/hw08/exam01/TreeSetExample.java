package hw08.exam01;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Student> treeSet = new TreeSet<>();
		treeSet.add(new Student("blue", 96));
		treeSet.add(new Student("hong", 86));
		treeSet.add(new Student("white", 92));
		
		Student student = treeSet.last();
		System.out.println("maxScore: " + student.score);
		System.out.println("maxScore ID: " + student.id);
	}
}