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
public class RegistrationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void showLogin(){
        JavaProject.showLogin();
    }
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private TextField txtConfirmPassword;
    
    @FXML
    private Label lblResult;
    
     //returns true if the fields are ready to be inserted in the Players file
    public boolean areFieldsOK(String username, String password, String confirmPassword){
        
        if(username.equals("") || password.equals("") || confirmPassword.equals("")){
            lblResult.setText("Please fill all the fields");
            return false;
        }  
        
        if(PlayerLogic.loginPlayer(username, "") == 1){
            lblResult.setText("Username already exists");
            return false;
        }  
        
         if(!password.equals(confirmPassword)){
            lblResult.setText("Passwords do not match");
            return false;
        }
                
        //if passwords are good and username is free then
        lblResult.setText("Registration Successful");
        return true;
    }
    
    //to register a new player
    @FXML
    public void registerPlayer(){
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        
        if(areFieldsOK(username, password, confirmPassword)){
        Player player = new Player(username, password, 0,("./sudokuSaved/"+username + "SudokuSavedGame.txt") );
        PlayerLogic.addPlayer(player);
        System.out.println("Registration Successful for" + player);
        txtUserName.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
       
        }
        else{
            System.out.println("Registration failed");
        }
    }
    
    
}
