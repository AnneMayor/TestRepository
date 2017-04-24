package ch17.exam38;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {

  @FXML
  private ProgressBar progressBar;
  @FXML
  private Label label;
  @FXML
  private Label lblWorkDone;
  @FXML
  private Button btnStart;
  @FXML
  private Button btnStop;
  @FXML
  private Label lblResult;

  private Task<Integer> task;

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    btnStart.setOnAction(event -> handleBtnStart(event));
    btnStop.setOnAction(event -> handleBtnStop(event));
  }

  private void handleBtnStart(ActionEvent event) {
    task = new Task<Integer>() {
      @Override
      protected Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i <= 100; i++) {
          result += i;
          double value = i;
          Platform.runLater(() -> {
            progressBar.setProgress(value/100); // 여기서 i는 final속성이기 때문에 절대 사용할 수 없음. 그렇기에 앞서 value 선언해주고 거기다 i값 받아서 넣어줌.
            lblWorkDone.setText(String.valueOf(value));
          });
          /*
          updateProgress(i, 100); // 얘도 thread객체가 시행! 이건 변하는 값 i와 최대값 100을 가진다. 
          updateMessage(String.valueOf(i));
           */
          if (isCancelled()) {
            break;
          }
          try {
            Thread.sleep(100);
          } catch (Exception e) {
            break;
          }
        }

        return result;
      }

      // 여기서부턴 JavaFX Application Thread가 시행. 앞의 call이 다 시행되고나면 JavaFX Application Thread가 시행되며 아래 메소드들이 시행됨. 
     // 굳이 여기를 선언해줘야 하는 이유는 작업이 끝났는지 안끝났는지 확인하기 위해서 써줘야 하는 부분.
      @Override
      protected void succeeded() {
        int result = getValue();
        lblResult.setText(String.valueOf(result));
        System.out.println("succeeded: " + Thread.currentThread().getName());
      }

      @Override
      protected void cancelled() {
        lblResult.setText("작업 취소됨");
      }

      @Override
      protected void failed() {
        System.out.println("failed: " + Thread.currentThread().getName());
      }
      // 이 부분은 runLater()를 호출하면 사용하지 않아도 되는 부분.
    };

    //progressBar.progressProperty().bind(task.progressProperty()); // 여긴 JavaFX Application Thread! 여기서 task매개변수를 갖는 작업스레드가 JavaFX Application Thread로 값을 넘겨줌.
    //lblWorkDone.textProperty().bind(task.messageProperty()); // 여기서는 task가 Double도 아니고 String타입도 아닌 속성을 넘겨줄 수 없음.
    Thread thread = new Thread(task); // 이건 task를 매개변수로 갖는 thread객체!
    thread.setDaemon(true);
    thread.start();
  }

  private void handleBtnStop(ActionEvent event) {
    task.cancel();
  }
}
