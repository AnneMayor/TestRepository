package ch18.exam29.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatServer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml")); // 히히 요거 한 내용인데 생각났다!후후
        Parent parent = FXMLLoader.load(getClass().getResource("server.fxml")); // getClass() = AppMain.class 여기서 FXML 파일 첫번째 태그가 무엇이냐에 따라 Parent 타입이 바뀜! 이거 명심! getClass().getResources(): 이 클래스 기준으로 안에 있는 객체값을 찾으라는 명령어
        
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Server");
        primaryStage.setOnCloseRequest(event -> { 
            ServerController.instance.stopServer(); // 이 방법 잘 알아두자!(
        });
        primaryStage.show();
    }
    
    public static void main(String... args) {
        launch(args);
    }
}