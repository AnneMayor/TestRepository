package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //1 . ��� ��ο��� test.txt ������ �޾ƿ��� �ڵ� �ۼ� 
        String path =  BufferExample.class.getResource("test.txt").getPath();
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        
        int readData = -1;
        // 2. ������ ���� ��E���� �о���� �ڵ� �ۼ�
        
        String str = br.readLine();
        System.out.println(str);
        
        
        br.close();
     //   fr.close();
    }
}
