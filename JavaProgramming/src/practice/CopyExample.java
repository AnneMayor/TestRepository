package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) throws IOException {
		FileInputStream is = new FileInputStream("src/practice/goblin.jpg");
		FileOutputStream os = new FileOutputStream("src/practice/goblin_poem.jpg");

		byte[] data = new byte[1024];
		int readBytes = -1;
		while (true) {
			readBytes = is.read(data);
			if (readBytes == -1) {
				break;
			}
			os.write(data, 0, readBytes);
			// is.read(data, 0, readBytes);
		}

		os.flush();
		os.close();
		is.close();
	}
}