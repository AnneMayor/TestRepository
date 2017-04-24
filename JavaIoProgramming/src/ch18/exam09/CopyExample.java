package ch18.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *CopyExample
 * @author Dahye Anne Lee
 */
public class CopyExample {
    public static void main(String ... args) throws FileNotFoundException, IOException {
        Reader reader = new FileReader("src/ch18/exam09/test.txt");
        Writer writer = new FileWriter("src/ch18/exam09/test2.txt");
        
        char[] data = new char[4];
        int readChar = -1;
        String str = null;
        while(true) {
            readChar = reader.read(data);
            if(readChar == -1) {
                break;
            }
            str = new String(data); // 바로 데이터로 뽑아줘도 상관없었군...쳇!이거 잘 알아둡시다~
            writer.write(str, 0, readChar);
        }
        
        
        
        writer.flush();
        reader.close();
        writer.close();
    }
}
