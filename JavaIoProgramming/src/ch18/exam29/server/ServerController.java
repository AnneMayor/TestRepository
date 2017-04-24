package ch18.exam29.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
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
    btnStartStop.setOnAction(event -> handleBtnStartStop(event));
  }

  private void handleBtnStartStop(ActionEvent e) {
    //System.out.println("Start");
    if (btnStartStop.getText().equals("Start")) {
      startServer();
    } else if (btnStartStop.getText().equals("Stop")) {
      stopServer();
    }
  }

  private void startServer() {
    // 스레드풀 생성
    executorService = Executors.newFixedThreadPool(100);

    //서버소켓 생성
    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost", 50001));

    } catch (IOException ex) {
      stopServer();
      return;
    }

    // 연결 수락 작업 정의
    Runnable acceptTask = () -> {
      // UI 변경 코드
      Platform.runLater(() -> {
        btnStartStop.setText("Stop");
        display("Server running!");
      });

      while (true) {
        // 수락 코드
        try {
          Socket socket = serverSocket.accept();
          String clientInfo = "[연결 수락: " + socket.getRemoteSocketAddress();
          Platform.runLater(() -> display(clientInfo)); // UI 변경 코드(이거 Platform.runLater() 안해주면 실행 안됨.

          // 통신용 Client 객체 생성
          Client client = new Client(socket);

          //Vector에 Client 저장
          connections.add(client);
          // 총 Client수 출력
          Platform.runLater(() -> display("[연결개수: " + connections.size() + "]"));
        } catch (IOException io) {
          stopServer();
          break;
        }
      }
    };
    // 스레드풀 작업큐에 작업 넣기
    executorService.submit(acceptTask);
  }

  public void stopServer() {

    try {
      serverSocket.close();
      
      executorService.shutdownNow();
      Platform.runLater(() -> {
        btnStartStop.setText("Start");
        display("Server stopped...");
      });
    } catch (IOException io) {
    }

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

      // 받기 작업 정리
      Runnable receiveTask = () -> {
        try {
          while (true) {
            // 스레드풀에 받기작업 넣기
            InputStream inputStream = socket.getInputStream();
            byte[] data = new byte[100];
            int readBytes = inputStream.read(data); // 예외: read메소드 비정상 종료, -1리턴: read메소드 정상 종료
            if (readBytes == -1) {
              throw new Exception();
            }

          }
        } catch (Exception io) {
          try {

            connections.remove(Client.this);
            String clientInfo = "[연결 끊김: " + socket.getRemoteSocketAddress();
            Platform.runLater(() -> display(clientInfo));
            this.socket.close();
          } catch (IOException ex) {

          }

        }
      };
      executorService.submit(receiveTask);
    }

    void send(String message) {

    }
  }
}
