package practice_exam24;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
		
		/*
		 * Button btn1 = new Button("Button1"); btn1.setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { System.out.println(
		 * "button1 clicked"); }
		 * 
		 * });
		 * 
		 * Button btn2 = new Button("Button2"); btn2.setOnAction(event ->
		 * System.out.println("button2 clicked"));
		 * 
		 * hbox.getChildren().addAll(btn1, btn2);
		 */
		
		Scene scene = new Scene(parent);
		primaryStage.setTitle("Popular List");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> System.out.println("closed"));
		primaryStage.show();
	}

}
