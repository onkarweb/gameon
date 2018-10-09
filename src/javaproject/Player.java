/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author Onkar
 */
public class Player implements Comparable{
    
    private String username;
    private String password;
    private int highScore;
    private String userFileName;

    public Player(String username, String password, int highScore, String userFileName) {
        this.username = username;
        this.password = password;
        this.highScore = highScore;
        this.userFileName = userFileName;
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getHighScore() {
        return highScore;
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void getPassword(String password) {
        
        this.password = password;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }
    
    public String toFileString(){

        return username + ":" + password + ":" + highScore + ":" + userFileName;

}

    @Override
    public String toString() {
        return "Player{" + "username=" + username + ", password=" + password + ", highScore=" + highScore + ", userFileName=" + userFileName + '}';
    }
    
    @Override
    public int compareTo(Object obj){
        if(obj == null)
            return -1;
        if(!(obj instanceof Player))
            return -1;
        Player player = (Player)obj;
        return this.highScore - player.highScore;
    }
    
    
}
