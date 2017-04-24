package ch18.exam12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class InputStreamReaderExample {

    public static void main(String... args) throws IOException {
        /*
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
 
        int data = is.read();
        data = isr.read(); // 주스트림과 보조스트림 시행 중 주스트림이 시행되면 보조스트림은 굳이 해줄 필요가 없어서 걍 출력을 주스트림이 하나보다...오호...!
        System.out.println((char) data);
         */

        // 저장된 파일의 인코딩이 어느것이냐에 따라 InputStreamReader가 깨짐. 
        InputStream is = new FileInputStream("src/ch18/exam12/test2.txt");
        InputStreamReader isr = new InputStreamReader(is, "EUC-KR"); // 이건 InputStreamReader 생성자 매개값 API 도큐먼트를 보면 알 수 있음.
        int data = isr.read();
        System.out.println((char) data);

    }
}
