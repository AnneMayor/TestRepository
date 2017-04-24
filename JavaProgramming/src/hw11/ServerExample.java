package hw11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		// Server�� ������ ServerSocket���� ����!
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 50002));
			while(true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("���� ����");
				
				InputStream is = socket.getInputStream();
				byte[] b = new byte[100];
				int readBytes = is.read(b);
				System.out.println("������ ���� ����");
				
				OutputStream os = socket.getOutputStream();
				String message = "Hello";
				byte[] data = message.getBytes();
				os.write(data);
				os.flush();
				
				is.close();
				os.close();
			}
		} catch(Exception e) {
			if(!serverSocket.isClosed()) {
				try {
				serverSocket.close();
				} catch(IOException io) {
						
				}
			}
			
		}
	}
}