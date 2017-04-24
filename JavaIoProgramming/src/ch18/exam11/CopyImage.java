package ch18.exam11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImage {
    public static void main(String...args) throws FileNotFoundException, IOException {
        FileInputStream fs = new FileInputStream("src/ch18/exam11/Desert.jpg");
        FileOutputStream fo = new FileOutputStream("src/ch18/exam11/Desert_copy.jpg");
        
        byte[] image = new byte[5*2^10*2^10]; // 그림 파일 메모리 단위로 바이트 단위 환산해서 생각하기!
        int readBytes = -1;
        while(true) {
            readBytes = fs.read(image);
            if(readBytes == -1) {
                break;
            }
            fo.write(image, 0, readBytes);
        }
      
        fo.flush();
        fo.close();
        fs.close();
    }
}