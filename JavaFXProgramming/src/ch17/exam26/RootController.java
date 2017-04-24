package ch17.exam26;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class RootController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void menueItemNew(ActionEvent event) {
        System.out.println("새로만들기 클릭됨");
    }
    
     @FXML
    private void javaApplicationNew(ActionEvent event) {
        System.out.println("자바애플리케이션 클릭됨");
    }
    
}
