package hw09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/hw09/test.txt");
		
		char[] data = new char[100];
		int readChars = fr.read(data);
		String str = new String(data, 0, readChars);
		System.out.println(str);
	}
}