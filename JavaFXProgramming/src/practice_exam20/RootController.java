package practice_exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {

    @FXML
    private ListView<Food> listView;

    // Initialize메소드 시작
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() {

            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>() {
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            return;
                        }
                        try {
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("fooditem.fxml")); // 
                            ImageView foodImage = (ImageView) hbox.lookup("#image");
                            Label foodName = (Label) hbox.lookup("#foodName");
                            ImageView star = (ImageView) hbox.lookup("#score");
                            Label content = (Label) hbox.lookup("#description");
                            foodImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString()));
                            foodName.setText(item.getFoodName());
                            star.setImage(new Image(getClass().getResource("images/" + "star"+ String.valueOf(item.getScore())+".png").toString()));
                            content.setText(item.getDescription());
                            setGraphic(hbox);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                return listCell;
            }

        });
        
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
               System.out.println(newValue.getFoodName()+ " " + newValue.getImage());
      
        });
        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("삼겹살", "food01.png", 4, "한국 최고의 음식 Best3"));
        listView.setItems(value);
    }
}