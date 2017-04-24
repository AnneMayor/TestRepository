package ch17.exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ListView<Phone> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listView.setCellFactory(new Callback<ListView<Phone>, ListCell<Phone>>() { // item.fxml에서 ImageView id가 fx:id가 아닌 id인 이유: Controller에서 쓸 것이 아니라(객채를 받을 목적이 아니라) updateItem메소드 안에서 직접 쓰는 것
            // ListView안에 하나의 Cell을 만드는 역할.

            @Override
            // FXML 파일 작성하여 코드로 개수만큼 마무리 
            public ListCell<Phone> call(ListView<Phone> param) { // listView에 phone이라는 객체가 들어올 때 자동으로 실행. ListView에 집어넣으려고 하는 객체의 수만큼 호출되어 시행.
                ListCell<Phone> listCell = new ListCell<Phone>() { // ListCell안에 Phone이라는 객체를 넣어주는 역할
                    @Override
                    protected void updateItem(Phone item, boolean empty) { // listCell에 뭐가 들어가는지를 정의하는 메소드. 
                        super.updateItem(item, empty); // 선택했을 때 나오는 값들이 바로 부모클래스에 들어있기에 이렇게 하지 않으면 안됨.
                        if (empty) {
                            return; // 맨처음에는 null값이 들어가니 이렇게 하면 ㄴㄴ!객체에 들어가지 않으니!
                        }
                        try {
                            // Cell에 들어갈 컨테이너 생성
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView phoneImage = (ImageView) hbox.lookup("#image"); // Node는 ImageView의 최상위 객체
                            Label phoneName = (Label) hbox.lookup("#name");
                            Label phoneContent = (Label) hbox.lookup("#content");

                            phoneImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString())); // 요거 봐라?!요렇게도 얻는구만ㅋㅋ잘 알아놓자!
                            phoneName.setText(item.getName());
                            phoneContent.setText(item.getContents());

                            // Cell의 내용으로 설정
                            setGraphic(hbox);

                        } catch (IOException io) {
                            io.printStackTrace();
                        }

                    }
                }; // 상속을 받은 익명객체!(익명구현객체는 인터페이스를 구현한 객체)
                return listCell;

            }

        }); // 리스트 한 행을 만드는 메소드라 생각하기
        // 선택 속성 감시
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
                System.out.println(newValue.getName() + " " + newValue.getImage());
            }
        });
        listView.setOnMouseClicked(e -> {
            Phone phone = listView.getSelectionModel().getSelectedItem();
            System.out.println(phone.getName());
        });

        // 데이터 세팅
        ObservableList<Phone> value = FXCollections.observableArrayList(); // 아니 얘는 왜 만날....에휴...잘 알아놓자!
        value.add(new Phone("phone01.png", "Gallexy s1", "The first model of Samsung"));
        value.add(new Phone("phone02.png", "Gallexy s1", "The first model of Samsung"));
        value.add(new Phone("phone03.png", "Gallexy s1", "The first model of Samsung"));
        listView.setItems(value);
    }
}
