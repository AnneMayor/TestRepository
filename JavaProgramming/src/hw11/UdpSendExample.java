package hw11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendExample {

	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		System.out.println("[�߽� ����]");
		
		for(int i = 0; i < 3; i++) {
			String message = "�޽���" + i;
			byte[] bytArr = message.getBytes("UTF-8");
			
			DatagramPacket packet = new DatagramPacket(bytArr, bytArr.length, new InetSocketAddress("localhost", 5002));
			datagramSocket.send(packet);
			
		System.out.println("���� ������ ��: " + bytArr.length+ " bytes");
		}
		System.out.println("[�߽� ����]");
		datagramSocket.close();
	}
}