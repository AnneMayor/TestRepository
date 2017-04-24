/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Administrator
 */
public class ReadExample {

    public static void main(String... args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath();
        InputStream is = new FileInputStream(path);
      
        // InputStream is = new FileInputStream("D:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\exam01\\test.txt");

        /*
        how1
        while (true) {
            int v1 = is.read();
            if (v1 == -1) { // 읽을게 없다면 -1을 리턴. 이거 중요!
                break;
            }
            System.out.print((char) v1); // 원래 문자코드를 문자로 바꾸는 실행문.
        }
         */
        System.out.println("------------------------------------------------------------");
        //how2
        int v2 = -1;
        while ((v2 = is.read()) != -1) {
            System.out.print((char) v2); // 얘는 한글은 2바이트인데 1바이트만 입력받았기에 결과값이 이상하게 나옴.
        }
    }
}