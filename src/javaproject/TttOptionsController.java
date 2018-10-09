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
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class TttOptionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    RadioButton rbSecondP;
    
    @FXML
    RadioButton rbComputerP;
    
    @FXML
    RadioButton rbEasy;
    
    @FXML
    RadioButton rbMedium;
    
    @FXML
    RadioButton rbHard;
    
    @FXML
    public void showWelcome(){
        JavaProject.showWelcome();
    }
    
    
    @FXML
    public void playBtn(){
       if(rbSecondP.isSelected()){
           TicTacToeLogic.isMultiplayer = true;
       }
       if(rbComputerP.isSelected()){
           TicTacToeLogic.isMultiplayer = false;
       }
       
       if(rbEasy.isSelected()){
           TicTacToeLogic.difficultyLevel = 1;
       }
       
       if(rbMedium.isSelected()){
           TicTacToeLogic.difficultyLevel = 2;
       }
       
       if(rbHard.isSelected()){
           TicTacToeLogic.difficultyLevel = 3;
       }
       
       JavaProject.showtttGame();
    }
    
    @FXML
    public void toggleDifficulty(){ 
        if(rbComputerP.isSelected()){
            rbEasy.setDisable(false);
            rbMedium.setDisable(false);
            rbHard.setDisable(false);
        }
        else{
            rbEasy.setDisable(true);
            rbMedium.setDisable(true);
            rbHard.setDisable(true);
        }
    }
    
}
