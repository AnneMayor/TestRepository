/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam03;

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
        // String path = WriteExample.class.getResource("test.txt").getPath();
        // OutputStream os = new FileOutputStream(path);
        OutputStream os = new FileOutputStream("src/ch18/exam03/test.txt"); // 이건 연습용! 이렇게 소스에다 저장하는 경우엔 정말 없다. 이건 정말 테스트용일뿐!
        for (int i = 0; i < 20; i++) {
            os.write(97);
        }
        // os.flush();
        // os.close();
        // Thread.sleep(100000); -> 이 코드가 시행해도 값이 출력되어 파일에 저장되긴하나 그렇다고 flush()메소드 선언 안해주면 ㄴㄴ. 교수님이 설명하신 내용이 맞음.

    }
}
