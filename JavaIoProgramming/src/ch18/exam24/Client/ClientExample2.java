package ch18.exam24.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample2 {

    public static void main(String... args) {
        Socket socket = null;
        try {
            //how1
            //socket = new Socket("192.168.3.27", 50001); // 원격접속 시에는 원격IP 입력해야 함.

            //how2
            // 소켓 생성
            socket = new Socket();
            // 연결 요청
            socket.connect(new InetSocketAddress("192.168.3.27", 50001));
           // String str = null;
            // str.length();
            // 통신 하기
            /*
            OutputStream os = socket.getOutputStream();
            String str = "후훗";
            byte[] data = str.getBytes("UTF-8");
            os.write(data);
            os.flush();
            System.out.println("데이터 보내기 성공");
            
            InputStream is = socket.getInputStream();
            int readBytes = 0;
            data = new byte[100];
            readBytes = is.read(data);
            str = new String(data, 0, readBytes, "UTF-8");
            System.out.println("받은 데이터: " + str);
            */
            
        } catch (IOException ex) {
            ex.printStackTrace();
            try {
                if (socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException ex1) {

            }
        }
    }
}
