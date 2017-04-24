package ch15.exam07;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String... args) {
		TreeSet<Person> set = new TreeSet<>(Collections.reverseOrder());
		set.add(new Person("Hong", 30));
		set.add(new Person("Shin", 40));
		set.add(new Person("You", 50));
		set.add(new Person("Kim", 20));
		set.add(new Person("Lee", 10));
		
		for(Person p: set) { // set.decendingSet() 
			System.out.println(p.getName() + p.getAge());
		}
	}
}