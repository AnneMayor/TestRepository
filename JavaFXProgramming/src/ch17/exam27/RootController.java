package ch17.exam27;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        System.out.println(file.getPath());

    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Button button = (Button) event.getSource(); // 컨트롤을 통해 속한 scene을 얻고 그 상위개념인 secne을 얻는다. 그런 다음 stage로 이동.
        Scene scene = button.getScene();
        Stage stage = (Stage) scene.getWindow();
        File file = fileChooser.showSaveDialog(stage); // 이렇게 쉽게 얻을 수 있음. FileChooser를 실행하고자 한다면 Stage가 얘를 띄워야 함.
        System.out.println(file.getPath());
    }

    @FXML
    private void handleDirectoryChooser(ActionEvent event) {
        DirectoryChooser drChooser = new DirectoryChooser();
        File file = drChooser.showDialog(((Button) event.getSource()).getScene().getWindow());
    }

    @FXML
    private void handlePopup(ActionEvent event) throws Exception {
        //showNotification("Notice", "1 Message received");
        showNotification("Warning", "1 Message received");
    }

    private void showNotification(String type, String message) throws Exception {
        Popup popup = new Popup();
        HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView) hbox.lookup("#imgMessage");
        Label lblMessage = (Label) hbox.lookup("#lblMessage");
        if (type.equals("Notice")) {
            imgMessage.setImage(new Image(getClass().getResource("icons/dialog-info.png").toString()));
        } else if (type.equals("Warning")) {
            imgMessage.setImage(new Image(getClass().getResource("icons/dialog-warning.png").toString()));
        } else if (type.equals("Error")) {
            imgMessage.setImage(new Image(getClass().getResource("icons/dialog-error").toString()));
        }
        popup.getContent().add(hbox);
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);
    }

    @FXML
    private void handleCustom(ActionEvent event) throws IOException {
        //showCustomDialog("정보", "Confirmed?");
        Stage dialog = new Stage(StageStyle.UNIFIED);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.show();
    }

    private void showCustomDialog(String type, String message) throws IOException {
        /*
        Stage dialog = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        ImageView icon = (ImageView) parent.lookup("#icon");
        Label lblMessage = (Label) parent.lookup("#message");
        Button btnOk = (Button) parent.lookup("#btnOk");

        if (type.equals("error")) {
            icon.setImage(new Image(getClass().getResource("icons/dialog-error.png").toString()));
        } else if (type.equals("help")) {
            icon.setImage(new Image(getClass().getResource("icons/dialog-help.png").toString()));
        } else if (type.equals("info")) {
            icon.setImage(new Image(getClass().getResource("icons/dialog-info.png").toString()));
        } else {
            icon.setImage(new Image(getClass().getResource("icons/dialog-warning.png").toString()));
        }

        lblMessage.setText(message);
        btnOk.setOnAction(event -> {
            dialog.hide();
        });
        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.initOwner(primaryStage);
        dialog.show();
         */
    }
}
