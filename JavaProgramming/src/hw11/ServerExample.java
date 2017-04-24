package hw11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		// Server는 무조건 ServerSocket으로 시작!
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 50002));
			while(true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("연결 성공");
				
				InputStream is = socket.getInputStream();
				byte[] b = new byte[100];
				int readBytes = is.read(b);
				System.out.println("데이터 전송 성공");
				
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