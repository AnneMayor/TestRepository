package hw10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialVersionUIDExample2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassC classc = (ClassC) ois.readObject();
		System.out.println(classc.field1);
		
		ois.close();
		fis.close();
	}
}

// �պκ��� ���� ���߽��ϴ�. �ָ��� �����ؼ� �ø��Կ�...