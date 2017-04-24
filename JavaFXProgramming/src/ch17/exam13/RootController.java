package ch17.exam13;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {

    @FXML
    private Button btn1;// anotation 반드시 써줘야하고 fx id와 필드명이 동일해야한다!
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //how1
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼1이 클릭됨");
            }
        });

        //how2 -> 이렇게 코드짜는걸 추천. 알겄지~?
        btn2.setOnAction(event -> {
            System.out.println("버튼2가 클릭됨");
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button4 activated");
            }
        });
        
        btn5.setOnAction(event -> {
            System.out.println("Button5 activated");
        });
    }

    //how3
    public void btn3Handle(ActionEvent event) {
        System.out.println("버튼3이 클릭됨");
    }
    
    public void btn6Handle(ActionEvent event) {
        System.out.println("Button6 activated");
    }
}
