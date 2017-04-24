package ch17.exam44;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {

  @FXML
  private Button btnLogin;

  @FXML
  private StackPane stackPane;

  public static StackPane rootPane;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    rootPane = stackPane;
    btnLogin.setOnAction(event -> handleBtnLogin(event));
  }

  private void handleBtnLogin(ActionEvent event) {

    try {

      Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
      stackPane.getChildren().add(parent);
      
      parent.setTranslateX(350);
      KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0); // What: translateXProperty(), Where: 0(종료값)으로 이동
      KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue); // 애니메이션 진행 시간: 0.1초(만약, 여러개의 애니메이션을 진행하고 싶으면 KeyValue와 KeyFrame 여러개 선언해주기
      Timeline timeLine = new Timeline();
      timeLine.getKeyFrames().add(keyFrame);
      timeLine.play();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
