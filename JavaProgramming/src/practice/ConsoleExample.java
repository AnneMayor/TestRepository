package practice;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleExample {
	public static void main(String...args) throws IOException {
		//how1
		InputStream is = System.in;
		
		byte[] data = new byte[100];
		is.read(data);
		String str = new String(data);
		System.out.println(str);
		
		//how2
		Scanner sc = new Scanner(System.in);
		String str2 = sc.nextLine();
		System.out.println(str2);
		
		//how3
		Console console = System.console();
		String str3 = console.readLine();
		System.out.println(str3);
		
		is.close();
	}
}
