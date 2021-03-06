package securitydisplay;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PasswordController implements Initializable {

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnConfirm;

	@FXML
	private Button btnCancel;

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
	private Button btn0;

	@FXML
	private TextField txtNumber;

	public static String password = "1234";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnDelete.setOnAction(event -> handleBtnDelete(event));

		// 키패드 버튼 이벤트 처리(0~9번까지)
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("1");
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("2");
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("3");
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("4");
			}
		});
		btn5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("5");
			}
		});
		btn6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("6");
			}
		});
		btn7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("7");
			}
		});
		btn8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("8");
			}
		});
		btn9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("9");
			}
		});
		btn0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtNumber.getText().length() > 5) {
					txtNumber.appendText("");
				}
				txtNumber.appendText("0");
			}
		});
	}

	// 지움버튼 이벤트 처리
	private void handleBtnDelete(ActionEvent event) {
		txtNumber.undo();
	}
}
