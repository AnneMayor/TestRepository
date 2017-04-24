package ch18.exam11;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
    public static void main(String ... args) throws IOException {
        File file = new File("src/ch18/exam11/FileExample.java");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isDirectory());

        File dir = new File("C:/Windows");
        System.out.println(dir.exists());
        System.out.println(dir.length());
        System.out.println(dir.isDirectory());
        
        String[] contents1 = dir.list(); // 해당 디렉토리 안의 디렉토리나 파일 이름.
        File[] contents2 = dir.listFiles(); // 해당 디렉토리 안의 파일 객체를 File[]안에 넣어줌.
        System.out.println(Arrays.toString(contents1));
        
        for(File file1 : contents2) {
            String info ="";
            info += file1.getName();
            info += "\t\t";
            info += (file1.isDirectory())?"<dir>":"";
            info += file1.length();
            System.out.println(info);
        }
        
        // 파일(디렉토리)의 생성 및 삭제
        File file2 = new File("C:/Temp/test.txt");
        file2.createNewFile();
        
        
        File dir2 = new File("C:/Temp/dir2");
        dir2.mkdir();
        dir2.delete(); // 디렉토리 안에 파일이 있으면 안지워진다!
        
        File dir3 = new File("C:/Temp/dir3/dir4/dir5");
        dir3.mkdirs(); // 경로상에 존재하지 않는 디렉토리들은 다시 새로 만들어라!
    }
}