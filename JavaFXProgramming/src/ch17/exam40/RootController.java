package ch17.exam40;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
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
  private Label lblWorkDone;
  @FXML
  private Label lblResult;
  @FXML
  private Button btnStart;
  @FXML
  private Button btnStop;

  private TimeService timeService;
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnStart.setOnAction(event -> handleBtnStart(event));
    btnStop.setOnAction(event -> handleBtnStop(event));
  }  

  private void handleBtnStart(ActionEvent e) {
    
    if(timeService == null) {
     timeService  = new TimeService(); 
     timeService.start(); // TimeService는 이미 스레드 가지고 있어서 Thread 생성해줄 필요 없음.
    } else {
      timeService.restart();
    }
  }

  private void handleBtnStop(ActionEvent e) {
    timeService.cancel();
  }
  
  class TimeService extends Service<Integer> {
    @Override
    protected Task<Integer> createTask() { // 작업을 생성하는 코드부분
      Task<Integer> task = new Task<Integer>() {
        @Override
        protected Integer call() throws Exception {
          int sum = 0;
          for(int i = 1; i <= 100; i++) {
            sum += i;
            if(isCancelled()) { break; }
            try{ 
              Thread.sleep(100);
            } catch(Exception ie) {
            }
            int value = i; // final특성때문에 이런거니 이거 잘 알아두자! 곧바로 i를 받아서 쓸 수가 없음.
              Platform.runLater(() -> {
                progressBar.setProgress(value/100.0);
                lblWorkDone.setText(String.valueOf(value));
              });
          }
          return sum;
        }
      };
      return task;
    }

    @Override
    protected void succeeded() {
      lblResult.setText(String.valueOf(getValue()));      
    }

    @Override
    protected void cancelled() {
      super.cancelled(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void failed() {
      super.failed(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  }
}