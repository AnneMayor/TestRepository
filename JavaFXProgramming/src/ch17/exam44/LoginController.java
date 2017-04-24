package ch17.exam44;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController implements Initializable {

  @FXML
  private BorderPane login;
  @FXML
  private Button btnMain;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnMain.setOnAction(event -> handleBtnMain(event));
  }

  private void handleBtnMain(ActionEvent event) {

    //how1
    //RootController.rootPane.getChildren().remove(login);
    StackPane rootPane = (StackPane) btnMain.getScene().getRoot();
    //rootPane.getChildren().remove(login); // 여기서 만약 인덱스 번호로 remove를 하게되면 헷갈리게 됨. StackPane에 여러 개의 컨테이너가 올라가면 그럼. 그리고 StackPane은 지울 수 있는 순서가 따로 있지 않음.

    //login.setTranslateX(0);
    login.setOpacity(1);

    Timeline timeLine = new Timeline();
    KeyValue keyValue = new KeyValue(login.opacityProperty(), 0);
    KeyFrame keyFrame = new KeyFrame(Duration.millis(5000),
            (e)
            -> rootPane.getChildren().remove(login),
             keyValue);
    timeLine.getKeyFrames().add(keyFrame);
    timeLine.play();

  }
}
