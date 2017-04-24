package ch18.exam15;

import ch18.exam14.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedExample {

    public static void main(String... args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam14/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw); // 생성자 매개값으로 받는 것이 앞서 보조스트림1이 Writer 사용해서 이렇다!
        
        // os.write(data);
        for(int i = 0; i < 1000; i++) {
            bw.write("가나다"); 
        }
      
        bw.flush();
        osw.flush();
        os.flush();
        
        bw.close();
        osw.close();
        os.flush();
        // close의 순서는 정말정말정말정말 뒤바뀌면 안된다...진심 그러면 프로그램 개망함...알았지?!(원리는 Buffer메모리 데이터 전송)
        
    }
}