/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam07;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class ReadExample {
    public static void main(String... args) throws FileNotFoundException, IOException {
       Reader reader = new FileReader("src/ch18/exam07/test.txt");
       
       char[] data = new char[3];
       int readByte = reader.read(data);
       System.out.print(Arrays.toString(data));
       
       readByte = reader.read(data);
       System.out.println(data);
       
       readByte = reader.read(data);
       String str = new String(data, 0, readByte);
       System.out.print(str);
    }
}