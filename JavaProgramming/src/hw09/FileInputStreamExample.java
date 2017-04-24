package hw09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamExample {

	public static void main(String[] args) {
		// FileInputStream ��ü ����(���ϰ������)
		// try-catch��: FileInputStream ��ü�� ������ �ÿ��� FileNotFoundException, SecurityException ���ܹ߻�.
		// read() 1����Ʈ �����͸� �б� ������ int�� �⺻Ÿ�� ���� ��������.
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