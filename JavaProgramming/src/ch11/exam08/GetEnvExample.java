package ch11.exam08;

import java.util.Map;
import java.util.Set;

public class GetEnvExample {

	public static void main(String[] args) {
		String value = System.getenv("USERNAME");
		System.out.println(value);
		/*
		Map map = System.getenv();
		Set keys = map.keySet();
		for(Object obj : keys) {
			String key = (String) obj;
			String value = System.getenv(key);
			System.out.println("[" + key + "]" + value);
		}
		*/
	}

}
