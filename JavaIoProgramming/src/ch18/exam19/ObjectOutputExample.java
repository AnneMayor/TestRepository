package ch18.exam19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {
    public static void main(String...args) throws FileNotFoundException, IOException {
       FileOutputStream fos = new FileOutputStream("src/ch18/exam19/object.dat");
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       
       Member member = new Member("Lee", 20);
       oos.writeObject(member);
       
       oos.flush();
       fos.flush();
       oos.close();
       fos.close();
    }
}
