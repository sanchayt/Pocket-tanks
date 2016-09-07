/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Dhruv Talwar
 */
public class Weapons {
    private String name;
    private int power;
    private int missedPow;
    private int x;
    private int y;
    private String url;
    private String description;

    public Weapons(String name, int power, int missedPow, String url, String description) {
        this.name = name;
        this.power = power;
        this.missedPow = missedPow;
        this.url = url;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMissedPow() {
        return missedPow;
    }

    public void setMissedPow(int missedPow) {
        this.missedPow = missedPow;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
