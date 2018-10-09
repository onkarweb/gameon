/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class HallofFameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
     @FXML
    private Label s3;

    @FXML
    private Label p1;

    @FXML
    private Label p2;

    @FXML
    private Label p3;

    @FXML
    private Label s1;

    @FXML
    private Label s2;
    
    @FXML
    public void showWelcome(){
        JavaProject.showWelcome();
    }
    
    public void displayTop3Players(){
        PlayerLogic.readPlayersFile();
        Player cPlayer = null;
        TreeSet<Player> orderedPlayers = new TreeSet(PlayerLogic.players);
        System.out.println("The top players are  " );
        
        for(int i = 0; i < 3; i++){
            cPlayer = orderedPlayers.last();
            System.out.println(cPlayer);
            
            if(i==0){
                p1.setText(cPlayer.getUsername());
                s1.setText(""+cPlayer.getHighScore());
            }
             if(i==1){
                p2.setText(cPlayer.getUsername());
                s2.setText(""+cPlayer.getHighScore());
            }
              if(i==2){
                p3.setText(cPlayer.getUsername());
                s3.setText(""+cPlayer.getHighScore());
            }
            
            
            orderedPlayers.pollLast();
        }
    }
    
    
    
    
}
