package com.example.demo123;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import javax.print.attribute.standard.Media;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.util.Duration;



public class HelloApplication extends Application {


    @FXML
    private Pane pane;
    @FXML
    private Label songLabel;
    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;
    @FXML
    private ComboBox<String> speedBox;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;
    private Media media;
    //private MediaPlayer mediaPlayer;
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
    private Timer timer;
    private TimerTask task;
    private boolean running;


    public HelloApplication() {
        songs = new ArrayList<File>();
        directory = new File("music");
        files = directory.listFiles();
        if(files != null) {
            for(File file : files) {
                System.out.println(file);
                songs.add(file);
            }
        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



    private boolean running;



    @Override

    public void initialize(URL arg0, ResourceBundle arg1) {



        songs = new ArrayList<File>();



        directory = new File("music");



        files = directory.listFiles();



        if(files != null) {



            for(File file : files) {



                songs.add(file);

            }

        }



        media = new Media(songs.get(songNumber).toURI().toString());

        mediaPlayer = new MediaPlayer(media);



        songLabel.setText(songs.get(songNumber).getName());



        for(int i = 0; i < speeds.length; i++) {



            speedBox.getItems().add(Integer.toString(speeds[i])+"%");

        }



        speedBox.setOnAction(this::changeSpeed);



        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {



            @Override

            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {



                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);

            }

        });



        songProgressBar.setStyle("-fx-accent: #00FF00;");

    }



    public void playMedia() {



        beginTimer();

        changeSpeed(null);

        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);

        mediaPlayer.play();

    }



    public void pauseMedia() {



        cancelTimer();

        mediaPlayer.pause();

    }



    public void resetMedia() {



        songProgressBar.setProgress(0);

        mediaPlayer.seek(Duration.seconds(0));

    }



    public void previousMedia() {



        if(songNumber > 0) {



            songNumber--;



            mediaPlayer.stop();



            if(running) {



                cancelTimer();

            }



            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);



            songLabel.setText(songs.get(songNumber).getName());



            playMedia();

        }

        else {



            songNumber = songs.size() - 1;



            mediaPlayer.stop();



            if(running) {



                cancelTimer();

            }



            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);



            songLabel.setText(songs.get(songNumber).getName());



            playMedia();

        }

    }



    public void nextMedia() {



        if(songNumber < songs.size() - 1) {



            songNumber++;



            mediaPlayer.stop();



            if(running) {



                cancelTimer();

            }



            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);



            songLabel.setText(songs.get(songNumber).getName());



            playMedia();

        }

        else {



            songNumber = 0;



            mediaPlayer.stop();



            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);



            songLabel.setText(songs.get(songNumber).getName());



            playMedia();

        }

    }



    public void changeSpeed(ActionEvent event) {



        if(speedBox.getValue() == null) {



            mediaPlayer.setRate(1);

        }

        else {



            //mediaPlayer.setRate(Integer.parseInt(speedBox.getValue()) * 0.01);

            mediaPlayer.setRate(Integer.parseInt(speedBox.getValue().substring(0, speedBox.getValue().length() - 1)) * 0.01);

        }

    }



    public void beginTimer() {



        timer = new Timer();



        task = new TimerTask() {



            public void run() {



                running = true;

                double current = mediaPlayer.getCurrentTime().toSeconds();

                double end = media.getDuration().toSeconds();

                songProgressBar.setProgress(current/end);



                if(current/end == 1) {



                    cancelTimer();

                }

            }

        };

        timer.scheduleAtFixedRate(task, 0, 1000);

    }
    public void cancelTimer() {
        running = false;

        timer.cancel();

    }

}