/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class Practice {
    public static void main(String... args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath();
        InputStream is = new FileInputStream(path);
        
        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
    }
}
