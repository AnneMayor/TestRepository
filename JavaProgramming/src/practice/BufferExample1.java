package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BufferExample1 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(BufferExample1.class.getResource("test1.txt").getPath());
		// InputStreamReader isr = new InputStreamReader(fr);
		BufferedReader br = new BufferedReader(fr);
		
		String str = null;
		
		while(true) {
			String str1 = br.readLine();
			if(str1 == null) { break;}
			System.out.println(str1);
			String[] str2 = str1.split("[.]");
			System.out.println(Arrays.toString(str2));
		}
		br.close();
		fr.close();
	}
}