package hw10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialVersionUIDExample1 {
	public static void main(String... args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassC c = new ClassC(100);
		oos.writeObject(c);
		
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
	}
}