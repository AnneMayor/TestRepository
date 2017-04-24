/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam02;

import ch18.exam01.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class ReadExample {

    public static void main(String... args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath();
        InputStream is = new FileInputStream(path);

        byte[] data = new byte[3];
        int readByte = -1;
        String strData = "";
        strData = new String(data);

        while (true) {
            readByte = is.read(data);
            if(readByte == -1) {
                break;
            }
            System.out.println(readByte);
            System.out.println(Arrays.toString(data));
            strData += new String(data, 0, readByte);
            System.out.println(strData);

        }
        // strData = new String(data, 0, readByte);
        // System.out.println("읽은 문자열: " + strData);
        is.close();

    }
}
