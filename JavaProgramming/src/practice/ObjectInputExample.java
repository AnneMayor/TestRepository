

package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ObjectInputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\study0414\\exam02\\object.dat");
        

        ObjectInputStream ois = new ObjectInputStream(fis);
       
        
           
        ois.close();
        fis.close();
        
        
    }

}
