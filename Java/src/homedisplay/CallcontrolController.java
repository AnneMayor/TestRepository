package homedisplay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class CallcontrolController implements Initializable {

  @FXML
  private TextArea txtNumber;
  @FXML
  private Button btn1;
  @FXML
  private Button btn2;
  @FXML
  private Button btn3;
  @FXML
  private Button btn4;
  @FXML
  private Button btn5;
  @FXML
  private Button btn6;
  @FXML
  private Button btn7;
  @FXML
  private Button btn8;
  @FXML
  private Button btn9;
  @FXML
  private Button btnCall;
  @FXML
  private Button btn0;
  @FXML
  private Button btnCancel;
  @FXML
  private Button btnGuardian;
  @FXML
  private Button btnApt;
  @FXML
  private Button btnPhone;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btn1.setOnAction(event -> handleBtn1(event));
    btn2.setOnAction(event -> handleBtn2(event));
    btn3.setOnAction(event -> handleBtn3(event));
    btn4.setOnAction(event -> handleBtn4(event));
    btn5.setOnAction(event -> handleBtn5(event));
    btn6.setOnAction(event -> handleBtn6(event));
    btn7.setOnAction(event -> handleBtn7(event));
    btn8.setOnAction(event -> handleBtn8(event));
    btn9.setOnAction(event -> handleBtn9(event));
    btn0.setOnAction(event -> handleBtn0(event));
    btnCancel.setOnAction(event -> handleBtnCancel(event));
    btnApt.setOnAction(event -> handleBtnApt(event));
    btnPhone.setOnAction(event -> handleBtnPhone(event));
    btnGuardian.setOnAction(event -> handleBtnGuardian(event));
    btnCall.setOnAction(event -> handleBtnCall(event));

  }

  private void handleBtn1(ActionEvent event) {
    txtNumber.appendText("1");
  }

  private void handleBtn2(ActionEvent event) {
    txtNumber.appendText("2");
  }

  private void handleBtn3(ActionEvent event) {
    txtNumber.appendText("3");
  }

  private void handleBtn4(ActionEvent event) {
    txtNumber.appendText("4");
  }

  private void handleBtn5(ActionEvent event) {
    txtNumber.appendText("5");
  }

  private void handleBtn6(ActionEvent event) {
    txtNumber.appendText("6");
  }

  private void handleBtn7(ActionEvent event) {
    txtNumber.appendText("7");
  }

  private void handleBtn8(ActionEvent event) {
    txtNumber.appendText("8");
  }

  private void handleBtn9(ActionEvent event) {
    txtNumber.appendText("9");
  }

  private void handleBtn0(ActionEvent event) {
    txtNumber.appendText("0");
  }

  private void handleBtnCancel(ActionEvent event) {
    txtNumber.undo();
  }

  private void handleBtnApt(ActionEvent event) {
    
  }

  private void handleBtnPhone(ActionEvent event) {
  }

  private void handleBtnGuardian(ActionEvent event) {
  }

  private void handleBtnCall(ActionEvent event) {
    
  }

}
