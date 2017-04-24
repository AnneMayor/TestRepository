package ch18.exam18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class LineDataExample {
    public static void main(String...args) throws FileNotFoundException, IOException {
       // 행단위 입출력 시 사용객체: FileOutputStream, PrintStream(PrintWriter) / FileInputStream, BufferedReader
        /*
        FileOutputStream fos = new FileOutputStream("src/ch18/exam18/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("홍길동");
        osw.write("Dahye Lee");
        osw.write("Java");
        
        osw.flush();
        fos.flush();
        osw.close();
        fos.close();
        */
        
        FileOutputStream fos = new FileOutputStream("src/ch18/exam18/test.txt");
        PrintStream out = new PrintStream(fos);
        out.println("abcde");
        out.println("lalala");
        out.flush();
        fos.flush();
        out.close();
        fos.close();
        
        
        FileInputStream fis = new FileInputStream("src/ch18/exam18/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        while(true) {
            String line = br.readLine();
            if(line == null) { break; }
            System.out.println(line);
        }
        
        br.close();
        isr.close();
        fis.close();
    }
}