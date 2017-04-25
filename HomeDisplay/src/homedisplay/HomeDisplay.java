package homedisplay;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeDisplay extends Application {
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("callcontrol.fxml"));
    Scene scene = new Scene(parent);
    primaryStage.setTitle("Call_UI");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
