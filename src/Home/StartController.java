/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Dhruv Talwar
 */
public class StartController implements Initializable {

    @FXML
    Button sound;
    @FXML
    Button play;
    @FXML
    Button inst;
    @FXML
    Button exit;
    @FXML
    AnchorPane back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    String ssound = "src/Sound/pocket.mp3";
    Media soundx = new Media(new File(ssound).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(soundx);

    @FXML
    public void functionSound() {
        if (sound.getGraphic() == null) {
            Image ticks = new Image("Images/tick.png");
            ImageView ticksv = new ImageView(ticks);
            ticksv.setFitHeight(20);
            ticksv.setFitWidth(20);
            sound.setGraphic(ticksv);
            mediaPlayer.play();
        } else {
            mediaPlayer.pause();
            sound.setGraphic(null);
            
        }
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    public void keyEvents(KeyEvent e) {
        switch (e.getCode()) {
            case ESCAPE:
                System.exit(0);
                break;
            case S:
                StartController.this.functionSound();
                break;
        }

    }

    @FXML
    public void playGame() {
        Home.showPlayer1();

    }

}
