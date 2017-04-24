/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam18;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {

    @FXML
    private TextField txtTitle;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox<String> comboPublic;
    @FXML
    private DatePicker dateExit;
    @FXML
    private TextArea txtContents;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnRegister;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 값이 유동적일 때 가능함!
        ObservableList<String> value = FXCollections.observableArrayList();
        value.add("공개");
        value.add("비공개");
        comboPublic.setItems(value);
    }    
    
    public void btnConHandle(ActionEvent event) {
        String title = txtTitle.getText();
        String password = txtPassword.getText();
        String strPublic = comboPublic.getValue();
        LocalDate localDate = dateExit.getValue();
        String content = txtContents.getText();
        
        System.out.println("title: " + title);
        System.out.println("password: " + password);
        System.out.println("Public: " + strPublic);
        System.out.println("localDate: " + localDate);
        System.out.println("content: " + content);
        
        
       
    }
    
}
