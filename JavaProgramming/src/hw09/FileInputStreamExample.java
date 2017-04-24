package hw09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamExample {

	public static void main(String[] args) {
		// FileInputStream 객체 생성(파일경로지정)
		// try-catch문: FileInputStream 객체를 생성할 시에는 FileNotFoundException, SecurityException 예외발생.
		// read() 1바이트 데이터만 읽기 때문에 int형 기본타입 변수 선언해줌.
		try {
			FileInputStream is = new FileInputStream("src/hw09/FileReaderExample.java");
			int data;
			while ((data = is.read()) != -1) {
				System.out.write(data);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}