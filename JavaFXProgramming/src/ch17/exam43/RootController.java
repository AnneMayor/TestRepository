package ch17.exam43;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

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

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
