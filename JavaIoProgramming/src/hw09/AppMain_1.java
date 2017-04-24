package hw09;

//2017.04.21
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain_1 extends Application {

  //start 재정의 
  @Override
  public void start(Stage primaryStage) throws Exception {
    //AnchorPane객체가 나옴
    Parent parent = FXMLLoader.load(getClass().getResource("server_1.fxml"));

    Scene scene = new Scene(parent);
    primaryStage.setScene(scene);
    primaryStage.setTitle("채팅창");

    primaryStage.show();
  }

  //main에서 launch시키기
  public static void main(String[] args) {
    launch(args);
  }

}
