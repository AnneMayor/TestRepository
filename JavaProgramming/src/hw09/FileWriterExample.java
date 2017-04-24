package hw09;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src/hw09/test.txt");
		
		String str = new String("-by °øÀ¯");
		fw.write(str);
		
		fw.flush();
		fw.close();
	}
}