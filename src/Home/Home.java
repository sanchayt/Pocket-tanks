/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dhruv Talwar
 */
public class Home extends Application {

    static Stage player1 = new Stage();
    static Stage home = new Stage();
    static Stage player2 = new Stage();
    public static Stage weapons = new Stage();
    public static Stage gameStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Parent Player1 = FXMLLoader.load(getClass().getResource("../Player1/Player1.fxml"));
        Parent Player2 = FXMLLoader.load(getClass().getResource("../Player2/Player2.fxml"));
        
        
        
        Scene scene = new Scene(root);
        home.setTitle("Pocket Tanks");
        home.setScene(scene);
        home.show();
        
        Scene scene3 = new Scene(Player1);
        player1 = new Stage();
        player1.setTitle("Pocket Tanks");
        player1.setScene(scene3);
        player1.show();
        
        
        weapons = new Stage();
        weapons.setTitle("Pocket Tanks");
       
        
        Scene scene4 = new Scene(Player2);
        player2 = new Stage();
        player2.setScene(scene4);
        player2.setTitle("Pocket Tanks");
        player2.show();
        
        gameStage = new Stage();
        gameStage.setTitle("Pocket Tanks");
        
        
        Home.showHome();
    }
    
    public static void showHome(){
        home.show();
        player2.hide();
        player1.hide();
        weapons.hide();
        gameStage.hide();
        
    } 
    public static void showPlayer1(){
        home.hide();
        player2.hide();
        player1.show();
        weapons.hide();
        gameStage.hide();
        
    }public static void showPlayer2(){
        home.hide();
        player2.show();
        player1.hide();
        weapons.hide();
        gameStage.hide();
        
    }
    public static void showWeaponsChoose(){
        home.hide();
        player2.hide();
        player1.hide();
        weapons.show();
        gameStage.hide();
        
    }
    public static void showGameStage(){
        home.hide();
        player2.hide();
        player1.hide();
        weapons.hide();
        gameStage.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
