/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam06;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Administrator
 */
public class ReadExample {

    // 문자열을 출력하는 Reader(잘 안쓰긴 함)
    public static void main(String... args) throws FileNotFoundException, IOException {
        Reader reader = new FileReader("src/ch18/exam06/test.txt");

        int v1 = -1;
        while (true) {
            v1 = reader.read(); // 한 문자를 읽는다! 여러개도 아니고 하나!
            if(v1 == -1) {
                break;
            }
            System.out.print((char)v1);
        }
        reader.close();
    }
}
