package Player1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.MySQL_Connect;
import Home.Home;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Dhruv Talwar
 */
public class Player1Controller implements Initializable {

    @FXML
    Button continueB;

    @FXML
    Button red;
    @FXML
    Button green;
    @FXML
    Button blue;
    @FXML
    Button cyan;
    @FXML
    Button purple;
    @FXML
    Button black;
    @FXML
    Label colour;
    @FXML
    TextField name;
    String color = "red";
    String url = "Images/tankRedS.png";
    @FXML
    StackPane image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    public void red() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        red.getStyleClass().clear();
        red.getStyleClass().add("customButtonBorder");
        green.getStyleClass().add("noBorder");
        cyan.getStyleClass().add("noBorder");
        black.getStyleClass().add("noBorder");
        purple.getStyleClass().add("noBorder");
        blue.getStyleClass().add("noBorder");
        color = red.getStyle().split(";")[0].split(":")[1].trim();
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url ="Images/tankRedS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());
        

    }

    public void green() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        green.getStyleClass().clear();
        green.getStyleClass().add("customButtonBorder");
        red.getStyleClass().add("noBorder");
        cyan.getStyleClass().add("noBorder");
        black.getStyleClass().add("noBorder");
        purple.getStyleClass().add("noBorder");
        blue.getStyleClass().add("noBorder");
        color = "green";
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url = "Images/tankGreenS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());
    }

    public void cyan() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        cyan.getStyleClass().clear();
        cyan.getStyleClass().add("customButtonBorder");
        green.getStyleClass().add("noBorder");
        red.getStyleClass().add("noBorder");
        black.getStyleClass().add("noBorder");
        purple.getStyleClass().add("noBorder");
        blue.getStyleClass().add("noBorder");
        color = "cyan";
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url = "Images/tankCyanS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());

    }

    public void black() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        black.getStyleClass().clear();
        black.getStyleClass().add("customButtonBorder");
        cyan.getStyleClass().add("noBorder");
        green.getStyleClass().add("noBorder");
        red.getStyleClass().add("noBorder");
        purple.getStyleClass().add("noBorder");
        blue.getStyleClass().add("noBorder");
        color = black.getStyle().split(";")[0].split(":")[1].trim();
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url="Images/tankBlackS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());

    }

    public void purple() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        purple.getStyleClass().clear();
        purple.getStyleClass().add("customButtonBorder");
        cyan.getStyleClass().add("noBorder");
        green.getStyleClass().add("noBorder");
        red.getStyleClass().add("noBorder");
        black.getStyleClass().add("noBorder");
        blue.getStyleClass().add("noBorder");
        color = "purple";
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url="Images/tankPurpleS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());

    }

    public void blue() {
        color = "";
        colour.getStyleClass().clear();
        name.getStyleClass().clear();
        blue.getStyleClass().clear();
        blue.getStyleClass().add("customButtonBorder");
        cyan.getStyleClass().add("noBorder");
        green.getStyleClass().add("noBorder");
        red.getStyleClass().add("noBorder");
        black.getStyleClass().add("noBorder");
        purple.getStyleClass().add("noBorder");
        color = blue.getStyle().split(";")[0].split(":")[1].trim();
        colour.setText(color.toUpperCase());
        colour.getStyleClass().add(color);
        name.getStyleClass().add(color);
        image.getChildren().clear();
        url="Images/tankBlueS.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());

    }

    @FXML
    public void openPlayer2() {
        MySQL_Connect.pl1.setName(name.getText());
        MySQL_Connect.pl1.setUserColor(color);
        MySQL_Connect.pl1.setTankURL(url);
        Home.showPlayer2();
       
        
    }
}
