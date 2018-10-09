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
public class SudokuOptionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    Label l ;
    
    @FXML
    public void showNewSudokuGame(){
        SudokuLogic.isNewGame = true;
        JavaProject.showSudokuGame();
        System.out.println("Sudoku Game Window opened");
    }
    
     //to load saved game
    //this changes the global sudoku grid to the saved game
    @FXML
    public void showSudokuSavedGame(){
        SudokuLogic.isNewGame = false;
        JavaProject.showSudokuGame();
        System.out.println("Sudoku Game Window opened");
    }
    
    @FXML
    public void showWelcome(){
        
        JavaProject.showWelcome();
        System.out.println("Entered Welcome window from Sudoku options");
    }
    }
    
    
