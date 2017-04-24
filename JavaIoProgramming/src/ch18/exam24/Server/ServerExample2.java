package ch18.exam24.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {

    public static void main(String... args) {
        ServerSocket serverSocket = null;
        try {
            // ServerSocket 생성
            serverSocket = new ServerSocket(); // 예외 발생: 네트워크 카드 발생
            // 포트 바인딩
            serverSocket.bind(new InetSocketAddress("192.168.3.27", 50001)); // 예외 발생: 이미 누가 동일 포트번호 사용중
            // 연결 기다리기
            while (true) {
                Socket socket = serverSocket.accept();
                // 클라이언트 정보 얻기
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // SocketAddress에선 쓸만한 메소드가 없기에 InetSocketAddress로 강제형변환
                // System.out.println(isa.toString());
                // System.out.println(isa.getHostName()); // 외부에서 접근하면 IP가 나옴.
                // 통신 하기
                InputStream is = socket.getInputStream();
                int readBytes = 0;
                byte[] data = new byte[100];
                // 100자 미만이라 반복문 필요 없음
                readBytes = is.read(data);
                if(readBytes == -1) { throw new IOException("정상종료"); }
                String str = new String(data, 0, readBytes, "UTF-8");
                System.out.println("받은 데이터: " + str);

                OutputStream os = socket.getOutputStream();
                data = str.getBytes("UTF-8");
                os.write(data);
                os.flush();
                System.out.println("데이터 보내기 성공");

                // 연결 끊기
                socket.close();
            }
        } catch (IOException ex) { // 현재 네트워크 어뎁터가 통신이 죽어있거나 할 때를 대비하면 된다!
            System.out.println(ex.getMessage()); // 클라이언트가 발생한 예외들 하나하나 제거해주는 역할
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