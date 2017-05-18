import java.io.FileReader;

public class DirectoryCreate {
	
	public static void main(String...args) {
		FileReader fr = new FileReader("C:\Users\Administrator\Desktop\company.txt");
		int readCharNo;
		char[] cbuf = new char[100];
		while((readCharNo = fr.read(cbuf) != -1)) {
			String data = new String(cbuf, 0, readCharNo);
		}
		fr.close();
		
		//FileWrite fw = new FileWriter();
	}
}
