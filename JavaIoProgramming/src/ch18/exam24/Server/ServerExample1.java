package ch18.exam24.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerExample1 {

    public static void main(String... args) {
        ServerSocket serverSocket = null;
        try {
            // ServerSocket 생성
            serverSocket = new ServerSocket(); // 예외 발생: 네트워크 카드 발생
            // 포트 바인딩
            serverSocket.bind(new InetSocketAddress("192.168.3.27", 50001)); // 예외 발생: 이미 누가 동일 포트번호 사용중
            // 연결 기다리기
            Socket socket = serverSocket.accept();
            // 클라이언트 정보 얻기
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // SocketAddress에선 쓸만한 메소드가 없기에 InetSocketAddress로 강제형변환
            System.out.println(isa.toString());
            System.out.println(isa.getHostName()); // 외부에서 접근하면 IP가 나옴.
            // 통신 하기

            // 연결 끊기
            socket.close();
        } catch (IOException ex) { // 현재 네트워크 어뎁터가 통신이 죽어있거나 할 때를 대비하면 된다!
            ex.printStackTrace();
            
            // ServerSocket이 50001번을 현재 사용하고 있느냐?
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    // ServerSocket 닫기(포트50001번 해제)
                    serverSocket.close();
                } catch (IOException ex1) {
                }
            }
        }
    }
}
