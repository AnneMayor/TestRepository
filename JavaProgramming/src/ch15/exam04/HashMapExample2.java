package ch15.exam04;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(100, "Dahye Lee"), 100);
		map.put(new Student(10000, "Shin"), 1);
		System.out.println(map.size());
	}

}
