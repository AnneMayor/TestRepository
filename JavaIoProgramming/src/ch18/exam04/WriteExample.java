/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam04;

import ch18.exam03.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Administrator
 */
public class WriteExample {

    public static void main(String... args) throws FileNotFoundException, IOException, InterruptedException {
        OutputStream os = new FileOutputStream("src/ch18/exam04/test.txt"); // 이건 연습용! 이렇게 소스에다 저장하는 경우엔 정말 없다. 이건 정말 테스트용일뿐!
        
        byte[] data = { 97, 98, 99 };
        // byte[] data = "abc".getBytes();
        
        os.write(data);
        os.flush();
        os.close();
              

    }
}
