/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam08;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Administrator
 */
public class WriteExample {
    public static void main(String... args) throws FileNotFoundException, IOException {
        Writer writer = new FileWriter("src/ch18/exam08/test.txt");
        
        char[] c1 ={ 'A' };
        writer.write(c1);
        
        char[] c2 = { '가', '나', '다', 'A' , '#' };
        writer.write(c2);
        writer.write(c2, 0, 2);
        
        writer.flush();
        writer.close();
    }
}