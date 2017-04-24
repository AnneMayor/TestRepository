package ch11.exam08;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		String osname = System.getProperty("os.name");
		System.out.println(osname);
		/*
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object obj : keys) {
			String key = (String) obj;
			String value = System.getProperty(key);
			System.out.println("[" + key + "]" + value);
		}
		*/
		
	}
}