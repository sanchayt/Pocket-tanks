/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Dhruv Talwar
 */
public class Player1 {
    private String userColor;
    private int power;
    private String name;
    ArrayList<Weapons> selectedWeapons;
    private int score;
    private int angle;
    private String tankURL;

    public String getTankURL() {
        return tankURL;
    }

    public void setTankURL(String tankURL) {
        this.tankURL = tankURL;
    }

    public Player1(String userColor, String name) {
        setName(name);
        setUserColor(userColor);
    }

    public Player1() {
        selectedWeapons = new ArrayList<>();
    }

    
    
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

 public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

   
}
