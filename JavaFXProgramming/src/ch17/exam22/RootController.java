/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam22;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class RootController implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private TableView<Phone> tableView;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancle;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> data1 = FXCollections.observableArrayList();
        data1.add("GallexyS1");
        data1.add("GallexyS2");
        data1.add("GallexyS3");
        listView.setItems(data1);
       
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
       
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone, String>("name")); // Phone객체에서 name필드의 값을 만들어서 넣어준다. 이때 name필드의 타입은 String이라는 의미
        tc1.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));
        
        ObservableList<Phone> value = FXCollections.observableArrayList();
        value.add(new Phone("phone01.png", "Gallexy s1", ""));
        value.add(new Phone("phone02.png", "Gallexy s2", ""));
        value.add(new Phone("phone03.png", "Gallexy s3", ""));
        
        tableView.setItems(value);
        
        listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            tableView.getSelectionModel().select(newValue.intValue());
            tableView.scrollTo(newValue.intValue());
        });
        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            imageView.setImage(new Image(getClass().getResource("images/" + newValue.getImage()).toString()));
        });
    }    
    
}
