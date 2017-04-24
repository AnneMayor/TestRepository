package ch15.exam04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Shin", 10);
		map.put("Lee", 20);
		map.put("Kim", 30);
		map.put("Hong", 40);
		map.put("Park", 50);
		System.out.println(map.size());
		
		System.out.println("\tȫ�浿 : " + map.get("ȫ�浿"));
		System.out.println("\tLee : " + map.get("Lee"));
		
		System.out.println();
		
		Set<String> keySet = map.keySet();//
		Iterator<String> keyIterator = keySet.iterator();//
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("Lee");
		System.out.println(map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();//
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.clear();
		System.out.println(map.size());
	}

}
