package ch17.exam02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox(); // Parent타입으로 리턴해도 문제 없음.

        Label label = new Label();
        label.setText("Hello JavaFX");
        vbox.getChildren().add(label); // getChildren()메소드는 List계열로 add명령어 사용
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(300);
        
        Button button = new Button();
        button.setText("Confirm");
        vbox.getChildren().add(button);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        launch(args); // 여기서 시행되면 start()메소드와 더불어 AppMain 생성자도 같이 호출함. 
    }
}
