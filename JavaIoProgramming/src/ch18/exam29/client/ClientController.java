package ch18.exam29.client;

import ch18.exam29.server.ServerController;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController implements Initializable {

  @FXML
  private Button btnConn;
  @FXML
  private TextField txtInput;
  @FXML
  private Button btnSend;
  @FXML
  private TextArea txtDisplay;

  private Socket socket;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnConn.setOnAction(event -> handleBtnConn(event));
    btnSend.setOnAction(event -> handleBtnSend(event));
  }

  private void handleBtnConn(ActionEvent event) {
    if (btnConn.getText().equals("Connect")) {
      startClient();
    } else if (btnConn.getText().equals("Disconnect")) {
      stopClient();
    }
  }

  private void startClient() {
    Thread thread = new Thread() {
      @Override
      public void run() {
        try {
          // 소켓 생성
          socket = new Socket();
          // 서버와 연결하기

          socket.connect(new InetSocketAddress("localhost", 50001));
          // 연결 성공 출력
          Platform.runLater(() -> {
            display("Connection Succeeded");
            btnConn.setText("Disconnet");
          });
          // 데이터 받기
          receive();
        } catch (Exception e) {
          Platform.runLater(()
                  -> {
            display("Connection failed");

          });
          stopClient();
          return;
        }
      }

    };
    thread.start();
  }

  // 아래를 JavaFX Application Thread 혹은 작업 스레드가 시행할 수 있으나 stopClinet()메소드를 runLater()안에서 호출해주면 JavaFX가 시행한다!
  private void stopClient() {
    try {
      socket.close();
    } catch (IOException io) {
      //Platform.runLater(() -> {
        btnConn.setText("Connect");
        display("Connection failed");
      //});

    }
  }

  private void display(String text) {
    txtDisplay.appendText(text + "\n");
  }

  private void handleBtnSend(ActionEvent event) {
    send(txtInput.getText());
  }

  private void send(String text) {
  }

  private void receive() {
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
      Platform.runLater(() -> display("[연결 끊김]"));
      stopClient();

    }
  }
}
