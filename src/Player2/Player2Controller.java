package Player2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.MySQL_Connect;
import Home.Home;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhruv Talwar
 */
public class Player2Controller implements Initializable {
   
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
    String color = "black";
    String url = "Images/tankBlack.png";
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
        url = "Images/tankRed.png";
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
        url="Images/tankGreen.png";
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
        url="Images/tankCyan.png";
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
        url = "Images/tankBlack.png";
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
        url="Images/tankPurple.png";
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
        url="Images/tankBlue.png";
        ImageView img = new ImageView(new Image(url));
        image.getChildren().add(img);
        img.setFitHeight(image.getPrefHeight());
        img.setFitWidth(image.getPrefWidth());

    }

    @FXML
    public void openWeaponsChoose() throws IOException{
        MySQL_Connect.pl2.setName(name.getText());
        MySQL_Connect.pl2.setUserColor(color);
        MySQL_Connect.pl2.setTankURL(url);
        FXMLLoader wc = new FXMLLoader(getClass().getResource("../ChooseWeapons/WeaponsChoose.fxml"));
        Parent root = wc.load();
        Scene scene = new Scene(root);
        Home.weapons = new Stage();
        Home.weapons.setScene(scene);
        Home.showWeaponsChoose();
      
    }
}
