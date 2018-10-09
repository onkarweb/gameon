/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    Label lblName;
    
    public void welcomeUserName(){        
        lblName.setText("Hi " + JavaProject.currentPlayer.getUsername());
    }
   @FXML
    public void showHallofFame(){
        JavaProject.showHallofFame();
    } 
    
    
    @FXML
    public void showLogin(){
        JavaProject.showLogin();
    }
    
    @FXML
    public void showSudokuOptions(){
        JavaProject.showSudokuOptions();
    }
    
    @FXML
    public void showtttOptions(){
        JavaProject.showtttOptions();
    }
    
}
