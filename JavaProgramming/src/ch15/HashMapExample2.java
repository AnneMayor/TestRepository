package hw0411_ch15.hashmap;

//변형
import java.util.*;

public class HashMapExample2 {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();

		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 90);

		System.out.println("총 엔트리 수: " + map.size());

		Set<Student> key = map.keySet();
		Iterator<Student> keyIterator = key.iterator();
		while (keyIterator.hasNext()) {
			Student student = keyIterator.next();
			System.out.println("홍길동 점수: " + map.get(student)); // 객체 그대로 넣으면 왜 안되는지
		}
	}
}
