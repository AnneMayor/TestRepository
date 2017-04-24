package ch17.exam24;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    @FXML
    private Slider sliderVolume;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label labelTime;
    
    private boolean endOfMedia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        //Media media = new Media(getClass().getResource("media/audio.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer); // 음악파일이면 이 코드 필요없음. 있어도 문제는 없음. 보통은 음악이냐 동영상이냐 선택하는 방식으로 진행됨.
        mediaPlayer.setOnReady(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            labelTime.setText(0 + " / " + (int)mediaPlayer.getTotalDuration().toSeconds() + " sec");
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
            progressBar.setProgress(1.0); // 재생완료후 '완료'라는 글자가 나오게 하려면 이 시행 꼭 해줘야 한다. 안그러면 100%밖에 안뜸. 
            progressIndicator.setProgress(1.0);
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
        
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue()/100.0);
            }
        });
        
        sliderVolume.setValue(50.0);
        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                //System.out.println(newValue.toSeconds());
                double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                progressBar.setProgress(progress);
                progressIndicator.setProgress(progress);
                labelTime.setText((int)newValue.toSeconds() + " / " + (int)mediaPlayer.getTotalDuration().toSeconds() + " sec");
            }
            
        });
    }
}