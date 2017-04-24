package ch17.exam21;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RootController implements Initializable {
    
    @FXML
    private TableView<Phone> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        TableColumn tc2 = tableView.getColumns().get(2);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone, String>("name")); // Phone객체에서 name필드의 값을 만들어서 넣어준다. 이때 name필드의 타입은 String이라는 의미
        tc1.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));
        tc2.setCellValueFactory(new PropertyValueFactory<Phone, String>("contents"));
        
        ObservableList<Phone> value = FXCollections.observableArrayList();
        value.add(new Phone("phone01.png", "Gallexy s1", "1st Model"));
        value.add(new Phone("phone02.png", "Gallexy s2", "2st Model"));
        value.add(new Phone("phone03.png", "Gallexy s3", "3st Model"));
        
        tableView.setItems(value);
    }    
}
