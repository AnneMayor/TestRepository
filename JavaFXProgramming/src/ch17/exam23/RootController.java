package ch17.exam23;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;

    private boolean endOfMedia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer); // 음악파일이면 이 코드 필요없음.
        mediaPlayer.setOnReady(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        mediaPlayer.setOnPlaying(() -> {
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });
        mediaPlayer.setOnPaused(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(false);
        });
        mediaPlayer.setOnStopped(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        mediaPlayer.setOnEndOfMedia(() -> {
            endOfMedia = true;
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });

        btnPlay.setOnAction(event -> {
            if (endOfMedia) {
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime()); // 시작시간을 찾는다는 의미의 메소드로 시작 시간으로 돌아가라는 의미!
            }
            mediaPlayer.play();
            endOfMedia = false;
        });
        btnPause.setOnAction(event -> mediaPlayer.pause());
        btnStop.setOnAction(event -> mediaPlayer.stop());
    }
}