package ch18.exam14;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedExample {

    public static void main(String... args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam14/test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte[] data = "가나다".getBytes();
        
        long startTime = System.nanoTime();

        // os.write(data);
        for(int i = 0; i < 1000; i++) {
            bos.write(data); 
        }
        
        long endTime = System.nanoTime();
        bos.flush();
        os.close();
        System.out.println(endTime - startTime);
    }
}
