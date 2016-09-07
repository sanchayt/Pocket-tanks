/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Classes.MySQL_Connect;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;






/**
 * FXML Controller class
 *
 * @author Dhruv Talwar
 */
public class GameController implements Initializable {

    @FXML
    StackPane p1Tank;
    @FXML
    StackPane p2Tank;
    @FXML
    Canvas canvas;
    @FXML
    Label p1Name;
    @FXML
    Label p2Name;
    @FXML
    Label p1Pow;
    @FXML
    Label p1Angle;
    @FXML
    Label p2Pow;
    @FXML
    Label p2Angle;
    @FXML
    Label p1weapon;
    @FXML
    Label p2weapon;
    @FXML
    AnchorPane backAgain;
    int count = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        p1Name.getStyleClass().clear();
        p2Name.getStyleClass().clear();
        p1Name.setText(MySQL_Connect.pl1.getName());
        p2Name.setText(MySQL_Connect.pl2.getName());
        p1Pow.setText("20");
        p1Angle.setText("60");
        p2Pow.setText("20");
        p2Angle.setText("120");
        p1Name.getStyleClass().add(MySQL_Connect.pl1.getUserColor());
        p2Name.getStyleClass().add(MySQL_Connect.pl2.getUserColor());
        p1weapon.setText(MySQL_Connect.getP1(0).getName());
        p2weapon.setText(MySQL_Connect.getP2(0).getName());
        p1Tank.getChildren().clear();
        ImageView p1imgv = new ImageView(new Image(MySQL_Connect.pl1.getTankURL()));
        p1Tank.getChildren().add(p1imgv);
        p1imgv.setFitWidth(130);
        p1imgv.setFitHeight(137);
        p2Tank.getChildren().clear();
        ImageView p2imgv = new ImageView(new Image(MySQL_Connect.pl2.getTankURL()));
        p2Tank.getChildren().add(p2imgv);
        p2imgv.setFitWidth(130);
        p2imgv.setFitHeight(137);
        
        

    }
    
    @FXML
    public void keyYO(KeyEvent e) {
        switch (e.getCode()) {
            case ESCAPE:
                System.exit(0);
                break;
            case W:
                if (count % 2 == 0) {
                    int pow = Integer.parseInt(p1Pow.getText());
                    p1Pow.setText(++pow + "");
                } else {
                    int pow = Integer.parseInt(p2Pow.getText());
                    p2Pow.setText(++pow + "");
                }
                break;
            case X:
                if (count % 2 == 0) {
                    int pow = Integer.parseInt(p1Pow.getText());
                    p1Pow.setText(--pow + "");
                } else {
                    int pow = Integer.parseInt(p2Pow.getText());
                    p2Pow.setText(--pow + "");
                }
                break;
            case D:
                if (count % 2 == 0) {
                    int angle = Integer.parseInt(p1Angle.getText());
                    p1Angle.setText(++angle + "");
                } else {
                    int angle = Integer.parseInt(p2Angle.getText());
                    p2Angle.setText(++angle + "");
                }
                break;
            case A:

                if (count % 2 == 0) {
                    int angle = Integer.parseInt(p1Angle.getText());
                    p1Angle.setText(--angle + "");
                } else {
                    int angle = Integer.parseInt(p2Angle.getText());
                    p2Angle.setText(--angle + "");
                }
                break;
            case SPACE:
                count++;
                break;
            default:System.out.println("yoo");
        }

    }

}
