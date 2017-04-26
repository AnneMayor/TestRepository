package homeProject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {

	@FXML
	private TextArea txtDisplay;
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
	private Button btnSharp;
	@FXML
	private Button btn0;
	@FXML
	private Button btnStar;
	@FXML
	private Button btnCass;
	@FXML
	private Button btnCancle;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btn1.setOnAction(e -> handleBtnNumber());
		btn2.setOnAction(e -> handleBtnNumber());
		btn3.setOnAction(e -> handleBtnNumber());
		btn4.setOnAction(e -> handleBtnNumber());
		btn5.setOnAction(e -> handleBtnNumber());
		btn6.setOnAction(e -> handleBtnNumber());
		btn7.setOnAction(e -> handleBtnNumber());
		btn8.setOnAction(e -> handleBtnNumber());
		btn9.setOnAction(e -> handleBtnNumber());
		btn0.setOnAction(e -> handleBtnNumber());
		btnSharp.setOnAction(e -> handleBtnNumber());
		btnStar.setOnAction(e -> handleBtnNumber());
		btnCass.setOnAction(e -> handleBtnNumber());
		btnCancle.setOnAction(e -> handleBtnNumber());
		
		
	}	

	private void handleBtnNumber() {
		if(btn1.isFocused()) {
			txtDisplay.appendText("1");
		} else if(btn2.isFocused()) {
			txtDisplay.appendText("2");
		} else if(btn3.isFocused()) {
			txtDisplay.appendText("3");
		} else if(btn4.isFocused()) {
			txtDisplay.appendText("4");
		} else if(btn5.isFocused()) {
			txtDisplay.appendText("5");
		} else if(btn6.isFocused()) {
			txtDisplay.appendText("6");
		} else if(btn7.isFocused()) {
			txtDisplay.appendText("7");
		} else if(btn8.isFocused()) {
			txtDisplay.appendText("8");
		} else if(btn9.isFocused()) {
			txtDisplay.appendText("9");
		} else if(btn0.isFocused()) {
			txtDisplay.appendText("0");
		} else if(btnSharp.isFocused()) {
			txtDisplay.appendText("#");
		} else if(btnStar.isFocused()) {
			txtDisplay.appendText("*");
		}  else if(btnCass.isFocused()) {
			txtDisplay.setText("전화 거는 중...........");
		} else if(btnCancle.isFocused()) {
			txtDisplay.undo();
		}
	}
	
}
