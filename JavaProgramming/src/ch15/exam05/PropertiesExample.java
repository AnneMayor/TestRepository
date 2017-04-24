package ch15.exam05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		String path = PropertiesExample.class.getResource("database.properties").getPath(); //getResource()메소드는 url 리턴. 그러므로 path값을 얻고 싶으면 getPath()메소드 호출필요! 
		prop.load(new FileReader(path));
		
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		String manager = prop.getProperty("manager");
		System.out.println(manager);
	}
}