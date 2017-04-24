package ch18.exam17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrimitiveDataExample {
    public static void main(String...args) throws FileNotFoundException, IOException {
        int value = 10;
        double value1 = 3.14;
        boolean value2 = false;
        String value3 = "HappyDay";
        OutputStream os = new FileOutputStream("src/ch18/exam17/test.dat"); // 확장자명이 txt가 아닌 dat인 이유: int값을 받아오기 때문에 바이너리 파일(dat)확장명을 사용하는 것!
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(value);
        dos.writeDouble(value1);
        dos.writeBoolean(value2);
        dos.writeUTF(value3);
        dos.flush();
        dos.close();
        
        InputStream is = new FileInputStream("src/ch18/exam17/test.dat");
        DataInputStream dis = new DataInputStream(is);
        int returnValue = dis.readInt();
        double returnValue1 = dis.readDouble();
        boolean returnValue2 = dis.readBoolean();
        String returnValue3 = dis.readUTF();
        System.out.println(returnValue);
        System.out.println(returnValue1);
        System.out.println(returnValue2);
        System.out.println(returnValue3);
        dis.close();
        is.close();
    }
}