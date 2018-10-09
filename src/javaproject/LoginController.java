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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private Label lblResult;
    
    
    @FXML
    public void showRegistration(){
        JavaProject.showRegistration();
    }
    
    public void showWelcome(){
        JavaProject.showWelcome();
    }
    
    public void showLoading(){
        JavaProject.showLoading();
    }
    
   
   
    //to login the user and if everything is right then make the current user this user
    //
    @FXML
    public void loginUser(){
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        
        int response = PlayerLogic.loginPlayer(username, password);
        switch(response){
            case -1: lblResult.setText("Username not found");
                     lblResult.setStyle("-fx-text-fill:red;");
                    break;
            case 1 : lblResult.setText("Username found! but password didn't match");
                     lblResult.setStyle("-fx-text-fill:red;");
                    break;
            case 2 :{lblResult.setText("Login Successful"); 
                     JavaProject.currentPlayer = PlayerLogic.players.get(PlayerLogic.indexOfPlayer(username, password));
                     System.out.println("THE EQUALITY IS " + JavaProject.currentPlayer.equals(PlayerLogic.players.get(0)));
                     System.out.println("current player is " + JavaProject.currentPlayer);
                     System.out.println("current player is " + PlayerLogic.players.get(0));
                     
                     System.out.println("Login detected! Current Player is " + JavaProject.currentPlayer );
                     //to enter the loading page
                     showLoading();
                     txtUserName.clear();
                     txtPassword.clear();
                     lblResult.setText("Please enter your details");
                     lblResult.setStyle("-fx-text-fill:black;");
                    break; 
            }
            default : lblResult.setText("Login failed! Unexpected error :("); 
                      lblResult.setStyle("-fx-text-fill:red;");
                    break;  
        }
            
    }
    
    
}
