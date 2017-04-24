package ch18.exam13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Administrator
 */
public class OutputStreamWriterExample {
    public static void main(String ... args) throws FileNotFoundException, IOException {
    OutputStream os = new FileOutputStream("src/ch18/exam13/test.txt");
    OutputStreamWriter osw = new OutputStreamWriter(os);
    
    /*    
    byte[] data = new byte[100];
    String str = "가";
    data = str.getBytes();
    */
    
    osw.write("가");
    osw.flush();
    osw.close();
    os.close();
    }
}
