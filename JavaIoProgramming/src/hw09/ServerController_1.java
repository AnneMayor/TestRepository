
package hw09;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController_1 implements Initializable {

	 @FXML
	 private Button btnStartStop;
	 @FXML
	 private TextArea txtDisplay;

	 
	 private ExecutorService executorService;
	 private ServerSocket serverSocket;
	 private List<Client> connections = new Vector<Client>(); // 스레드 들이 벡터 쓰도록
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {

			btnStartStop.setOnAction(e->handBtnStartStop(e));

	 }	 

	 private void handBtnStartStop(ActionEvent e) {
			
			if(btnStartStop.getText().equals("시작")){
				 startServer();
			}
			else if(btnStartStop.getText().equals("멈춤")){
				 stopServer();
			}
			
	 }
	 private void startServer(){
			btnStartStop.setText("시작");
			display("서버 시작");
	 }
	 private void stopServer(){
			btnStartStop.setText("멈춤");
			display("서버 멈춤");
	 }
	 private void display(String text){
			txtDisplay.appendText(text+"\n");
	 }
	 class Client{
			Socket socket;
			
			Client(Socket socket){
				 this.socket = socket;
			}
			
			void receive(){
			
				 
			}
			
			void send(String message){
				 
			}
	 }
	 
}
