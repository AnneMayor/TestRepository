package ch17.exam01;

import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppMain extends Application {

    /*
    public AppMain() {
        System.out.println("Constructor");
        // System.out.println(Thread.currentThread().getName());

    }
     */
    
    @Override
    public void init() throws Exception {
        System.out.println("init");
        // System.out.println(Thread.currentThread().getName());
        Parameters params = getParameters();

        /*
        List<String> list = params.getRaw();
        for(String param : list) {
            System.out.println(params);
         */
        // java AppMain --ip="192.168.3.27" --port=50001
        // 실행옵션을 줘야한다면 이런 코드를 짜는 것. 만약 필요없다면 쓸 필요 없음. 매개변수의 값을 활용하고자 한다면 이 코드를 작성하는 것
        Map<String, String> map = params.getNamed();
        String ip = map.get("ip"); // 키로 Value얻기
        String port = map.get("port");
        System.out.println(ip);
        System.out.println(port);
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        System.out.println(Thread.currentThread().getName());
    }
     */
    public static void main(String... args) {
        launch(args); // 여기서 시행되면 start()메소드와 더불어 AppMain 생성자도 같이 호출함. 
        Platform.exit();
    }
}
