package ch11.exam09;

import java.io.IOException;

public class StringConstructorExample {

	public static void main(String[] args) throws Exception {
		
		/*
		String s1 = "abc";
		String s2 = new String("abc");
		
		char[] charArray = { 'a', 'b', 'c' };
		String s3 = new String(charArray);
		
		byte[] byteArray = { 49, 50, 51 };
		String s4 = new String(byteArray);
		System.out.println(s4);
		
		byte[] inputData = new byte[100];
		int readByteNo = System.in.read(inputData);
		String strData = new String(inputData, 0, readByteNo-2);
		*/
		
		byte[] byteArray1 = { 49, 50, 51, 52, 53, 54, 55 };
		String strData1 = new String(byteArray1, 3, 3);
		System.out.println(strData1);
		
	}
}
