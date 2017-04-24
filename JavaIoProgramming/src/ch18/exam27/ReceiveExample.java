package ch18.exam27;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 항상 여기서부터 실행을 먼저 하고 받을 준비를 해야함.
public class ReceiveExample {
    public static void main(String...args) throws SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket(50002);
        
        DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);// 데이터가 아직 들어오지 않은 바이트배열 선언
        
        datagramSocket.receive(datagramPacket); // 데이터가 안오면 여기서 blocking(대기)상태에 빠짐. 
        
        byte[] data = datagramPacket.getData();
        int readBytes = datagramPacket.getLength();
        System.out.println(new String(data, 0, readBytes)); // 5바이트만 딱 읽기 위해 이렇게 작성. 
        
        datagramSocket.close();
    }
}
