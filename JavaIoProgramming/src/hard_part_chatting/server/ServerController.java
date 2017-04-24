package hard_part_chatting.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {

  public static ServerController instance;

  @FXML
  private Button btnStartStop;
  @FXML
  private TextArea txtDisplay;

  private ExecutorService executorService;
  private ServerSocket serverSocket;
  private List<Client> connections = new Vector<Client>();

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    ServerController.instance = this;
    btnStartStop.setOnAction(e -> handleBtnStartStop(e));
  }

  private void handleBtnStartStop(ActionEvent e) {
    if (btnStartStop.getText().equals("시작")) {
      startServer();
    } else if (btnStartStop.getText().equals("멈춤")) {
      stopServer();
    }
  }

  private void startServer() {
    //스레드풀 생성
    executorService = Executors.newFixedThreadPool(100);

    //서버 소켓 생성
    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("192.168.3.27", 50001));
    } catch (IOException ex) {
      stopServer();
      return;
    }

    //연결 수락 작업 정의
    Runnable acceptTask = () -> {
      //UI 변경 코드
      Platform.runLater(() -> {
        btnStartStop.setText("멈춤");
        display("서버 시작...");
      });
      while (true) {
        try {
          //수락 코드
          Socket socket = serverSocket.accept();
          //연결된 클라이언트 정보 출력
          String clientInfo = "[연결 수락: " + socket.getRemoteSocketAddress() + "]";
          Platform.runLater(() -> display(clientInfo));
          //통신용 Client 객체 생성
          Client client = new Client(socket);
          //Vector에 Client 저장
          connections.add(client);
          //총 Client 수 출력
          Platform.runLater(() -> display("[연결 개수: " + connections.size() + "]"));
        } catch (IOException ex) {
          stopServer();
          break;
        }
      }
    };

    //스레드풀의 작업큐에 작업 넣기
    executorService.submit(acceptTask);
  }

  public void stopServer() {
    try {
      Iterator<Client> iterator = connections.iterator();
      while(iterator.hasNext()) {
        Client client = iterator.next();
        client.socket.close();
      }
      
      /*
      //how1(괜찮은 방법) - Vector안의 Client객체의 스레드를 닫아주고 Vector안 지워주기
      for(Client client : connections) {
        client.socket.close(); // 만약 여기서 connections.remove(client) 해버리면 for문의 변수들이 변환값을 인식하지 못해서 에러가 난다...
      }
      connections.clear();
      */
      executorService.shutdownNow();
      serverSocket.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Platform.runLater(() -> {
      btnStartStop.setText("시작");
      display("서버 멈춤...");
    });
  }

  private void display(String text) {
    txtDisplay.appendText(text + "\n");
  }

  class Client {

    Socket socket;

    Client(Socket socket) {
      this.socket = socket;
      receive();
    }

    void receive() {
      //받기 작업 정의
      Runnable receiveTask = () -> {
        try {
          while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] byteArr = new byte[100];
            int readBytes = inputStream.read(byteArr);
            if (readBytes == -1) {
              throw new Exception();
            }
            String str = new String(byteArr, 0, readBytes);
            for(Client client : connections) {
              client.send(str);
            }
          }
        } catch (Exception e) {
          try {
            String clientInfo = "[연결 끊김: " + socket.getRemoteSocketAddress() + "]";
            Platform.runLater(() -> display(clientInfo));
            this.socket.close();
            connections.remove(Client.this);
            Platform.runLater(() -> display("[연결 개수: " + connections.size() + "]"));
          } catch (IOException ex) {
          }
        }
      };

      //스레드풀의 작업큐에 작업 넣기
      executorService.submit(receiveTask);
    }

    void send(String message) {
      try { // 여긴 무조건 ty-catch 안그러면 통신 소켓을 닫아 다른 멀쩡한 클라이언트들한테도 정보전송이 안됨. 
        
      OutputStream os = socket.getOutputStream(); 
      byte[] data = message.getBytes();
      os.write(data);
      os.flush();
      os.close();
      } catch(IOException io) {
        connections.remove(Client.this);
        try {
        socket.close();
        } catch(Exception e) {}
      }
      
      
    }
  }
}
