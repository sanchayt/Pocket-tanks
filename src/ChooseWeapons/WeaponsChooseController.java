/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChooseWeapons;

import Classes.MySQL_Connect;
import Classes.Weapons;
import static Home.Home.gameStage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhruv Talwar
 */
public class WeaponsChooseController implements Initializable {

    @FXML
    VBox weapons;
    @FXML
    VBox player1Box;
    @FXML
    VBox player2Box;
    @FXML
    Label player1Lbl;
    @FXML
    Label player2Lbl;
    @FXML
    FlowPane weapons0;
    @FXML
    FlowPane weapons1;
    @FXML
    FlowPane weapons2;
    @FXML
    FlowPane weapons3;
    @FXML
    FlowPane weapons4;
    @FXML
    FlowPane weapons5;
    @FXML
    FlowPane weapons6;
    @FXML
    FlowPane weapons7;
    @FXML
    FlowPane weapons8;
    @FXML
    FlowPane weapons9;
    @FXML
    FlowPane weaponsP10;
    @FXML
    FlowPane weaponsP11;
    @FXML
    FlowPane weaponsP12;
    @FXML
    FlowPane weaponsP13;
    @FXML
    FlowPane weaponsP14;
    @FXML
    FlowPane weaponsP20;
    @FXML
    FlowPane weaponsP21;
    @FXML
    FlowPane weaponsP22;
    @FXML
    FlowPane weaponsP23;
    @FXML
    FlowPane weaponsP24;
    int countP1 = 0;
    int countP2 = 0;
    int count = 0;
    ArrayList<Weapons> topWeapons;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        weapons.setVisible(true);
        topWeapons = new ArrayList<>();
        MySQL_Connect.weaponsEntry();
        topWeapons.addAll(MySQL_Connect.list);
        Collections.shuffle(topWeapons);

        topWeapons.remove(topWeapons.size() - 2);

        FlowPane[] weaponsAll = {weapons0, weapons1, weapons2, weapons3, weapons4, weapons5, weapons6, weapons7, weapons8, weapons9};

        for (int i = 0; i < topWeapons.size(); i++) {
            Button text = (Button) weaponsAll[i].getChildren().get(1);
            text.setText(topWeapons.get(i).getName());
            Button img = (Button) weaponsAll[i].getChildren().get(0);
            ImageView imgvc = new ImageView(new Image(topWeapons.get(i).getUrl().substring(3)));

            img.setGraphic(imgvc);
            imgvc.setFitHeight(40);
            imgvc.setFitWidth(40);

        }
            System.out.println(MySQL_Connect.pl1.getUserColor());
            System.out.println(MySQL_Connect.pl2.getUserColor());
        
            player1Box.getStyleClass().clear();
            player1Box.getStyleClass().add(MySQL_Connect.pl1.getUserColor());
            player2Box.getStyleClass().clear();
            player2Box.getStyleClass().add(MySQL_Connect.pl2.getUserColor());
            player2Lbl.setText(MySQL_Connect.pl2.getName());
            player1Lbl.setText(MySQL_Connect.pl1.getName());
            player1Lbl.getStyleClass().clear();
            player1Lbl.getStyleClass().add(MySQL_Connect.pl1.getUserColor());
            player2Lbl.getStyleClass().clear();
            player2Lbl.getStyleClass().add(MySQL_Connect.pl2.getUserColor());
        
    }

    @FXML
    public void openGameStage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Game/game.fxml"));
         Scene scene = new Scene(root);
        Home.Home.gameStage = new Stage();
        Home.Home.gameStage.setScene(scene);
        gameStage.setTitle("Pocket Tanks");
        
        Home.Home.showGameStage();
    }

    @FXML
    public void random() {
        MySQL_Connect.clearP1();
        MySQL_Connect.clearP2();
        ArrayList<Weapons> allWeapons = new ArrayList<>(topWeapons);
        Collections.shuffle(allWeapons);
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};
        for (int i = 0; i < allWeapons.size(); i++) {
            if (i < 5) {
                Button img = (Button) player1[i].getChildren().get(0);
                ImageView imgc = new ImageView(new Image(allWeapons.get(i).getUrl().substring(3)));
                img.setGraphic(imgc);
                imgc.setFitHeight(40);
                imgc.setFitWidth(40);
                Button text = (Button) player1[i].getChildren().get(1);
                text.setText(allWeapons.get(i).getName());
                MySQL_Connect.addWeaponstoP1(allWeapons.get(i));

            } else {
                Button img = (Button) player2[i - 5].getChildren().get(0);
                ImageView imgc = new ImageView(new Image(allWeapons.get(i).getUrl().substring(3)));
                img.setGraphic(imgc);
                imgc.setFitHeight(40);
                imgc.setFitWidth(40);
                Button text = (Button) player2[i - 5].getChildren().get(1);
                text.setText(allWeapons.get(i).getName());
                MySQL_Connect.addWeaponstoP2(allWeapons.get(i));

            }
        }
        weapons.setVisible(false);
    }

    @FXML
    public void weapon0click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons0.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons0.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    System.out.println(i);
                    System.out.println(topWeapons.get(i).getName());
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
            
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");
        count++;
    }

    @FXML
    public void weapon1click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons1.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons1.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");
        count++;
    }

    @FXML
    public void weapon2click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons2.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons2.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon3click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons3.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons3.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
            countP1++;
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon4click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons4.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons4.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon5click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons5.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons5.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon6click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons6.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons6.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon7click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons7.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons7.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon8click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons8.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons8.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

    @FXML
    public void weapon9click() {
        FlowPane[] player1 = {weaponsP10, weaponsP11, weaponsP12, weaponsP13, weaponsP14};
        FlowPane[] player2 = {weaponsP20, weaponsP21, weaponsP22, weaponsP23, weaponsP24};

        Button img = (Button) weapons9.getChildren().get(0);
        ImageView imgc = (ImageView) img.getGraphic();
        Button text = (Button) weapons9.getChildren().get(1);
        String weaponName = text.getText();

        int playerCount = (count % 2);
        int weaponCountP1 = countP1 % 5;
        int weaponCountP2 = countP2 % 5;

        if (playerCount == 0) {
            Button imgP = (Button) player1[weaponCountP1].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player1[weaponCountP1].getChildren().get(1);
            textP.setText(weaponName);
            countP1++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP1(topWeapons.get(i));
                }
            }
        } else {
            Button imgP = (Button) player2[weaponCountP2].getChildren().get(0);
            imgP.setGraphic(imgc);
            Button textP = (Button) player2[weaponCountP2].getChildren().get(1);
            textP.setText(weaponName);
            countP2++;
            for(int i=0;i<topWeapons.size();i++){
                if(topWeapons.get(i).getName().equals(weaponName)){
                    MySQL_Connect.addWeaponstoP2(topWeapons.get(i));
                }
            }
        }
        text.setText("");

        count++;
    }

}
