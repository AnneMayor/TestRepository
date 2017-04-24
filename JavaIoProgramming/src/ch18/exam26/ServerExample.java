package ch18.exam26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        ServerSocket serverSocket = null;
        try {
            // ServerSocket 생성
            serverSocket = new ServerSocket();
            // 포트와 바인딩
            serverSocket.bind(new InetSocketAddress(50001));

            // 연결 기다리기
            // 서버 계속 열어두기 위해 while문 추가
             System.out.println("[Client의 연결을 기다립니다.]");
            while (true) {
                Socket socket = serverSocket.accept();
               

                Runnable task = () -> {
                    try {
                        // 통신하기 -> 클라이언트와 반대로 스트림 생성
                        InputStream is = socket.getInputStream();

                        //2) 서버에서 보낸 내용 받기
                        byte[] data = new byte[100];
                        int readByte = is.read(data);

                        if (readByte == -1) { // 클라이언트가 암것도 안보내고 혼자 종료된 경우
                            throw new IOException("클라이언트가 정상 종료됨");

                        }

                        String strData = new String(data, 0, readByte, "UTF-8");
                        System.out.println("받은 데이터: " + strData);

                        //3) 이제, 서버에서 클라이언트로 보낸다.
                        OutputStream os = socket.getOutputStream();

                        data = strData.getBytes();
                        os.write(data);
                        os.flush();
                        System.out.println("데이터 보내기 성공");

                        // 연결 끊기
                        socket.close();
                    } catch (IOException e) {
                    }
                }; // Runnable 익명 객체의 끝
                
                executorService.submit(task);
                
            }//while문의 끝

        } catch (IOException ex) {

        }

        if (serverSocket != null && serverSocket.isClosed()) { // 서버 소켓이 현재 50001 포트를 사용하고 있느냐
            //Seversocket 닫기
            try { // 사용하고 있으면 소켓 닫아줘라 (50001번 포트해제)
                serverSocket.close();
            } catch (IOException ex1) {
            }
        }

    }
}
