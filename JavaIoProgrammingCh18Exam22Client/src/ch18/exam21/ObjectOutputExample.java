package ch18.exam21;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {

    public static void main(String... args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("C:/Temp/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Member member = new Member("Lee", 20);
        // Member.nation = "Canada";
        oos.writeObject(member);
        
        System.out.println(member.getAge());
        System.out.println(member.getName());


        oos.flush();
        fos.flush();
        oos.close();
        fos.close();
    }
}
