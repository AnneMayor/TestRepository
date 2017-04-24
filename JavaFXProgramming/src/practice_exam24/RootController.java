package practice_exam24;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Callback;

public class RootController implements Initializable {
  // Field

  @FXML
  private ListView<Music> listView;

  private boolean endOfMedia;

  // Method
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    listView.setCellFactory(new Callback<ListView<Music>, ListCell<Music>>() {

      @Override
      public ListCell<Music> call(ListView<Music> param) {
        ListCell<Music> listCell = new ListCell<Music>() {
          @Override
          protected void updateItem(Music item, boolean empty) {
            if (empty) {
              return;
            }
            try {
              HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("listview.fxml"));
              ImageView albumImage = (ImageView) hbox.lookup("#image");
              MediaView albumSong1 = (MediaView) hbox.lookup("#mediaView");
              Label albumTitle = (Label) hbox.lookup("#title");
              Label albumSinger = (Label) hbox.lookup("#name");
              Button albumSong = (Button) hbox.lookup("#music");
              // Hyperlink albumLink = (Hyperlink)
              // albumSong.lookup("#link");

              albumImage.setImage(new Image(getClass().getResource("images/" + item.getImage() + ".png").toString()));
              albumTitle.setText(item.getTitle());
              albumSinger.setText(item.getName());

              albumSong.setOnAction(e -> {
                // albumLink.fire();
                // albumLink.setOnAction(event ->
                // System.out.println("Go to Melon"));

                Media media = new Media(getClass().getResource("media/audio.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                albumSong1.setMediaPlayer(mediaPlayer);

                if (endOfMedia) {
                  mediaPlayer.setOnReady(() -> {
                    albumSong.setDisable(false);
                  });
                }
                mediaPlayer.play();
                endOfMedia = true;
              });

              setGraphic(hbox);

            } catch (IOException io) {
            }
          }
        };
        return listCell;
      }

    });

    ObservableList<Music> value = FXCollections.observableArrayList();
    value.add(new Music("IU", "밤편지", "food01"));
    value.add(new Music("Zico", "featuring", "food02"));
    value.add(new Music("G-Dragon", "쿠데타", "food03"));
    listView.setItems(value);
  }
}
