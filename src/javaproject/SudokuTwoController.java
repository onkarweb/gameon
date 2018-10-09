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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class SudokuTwoController implements Initializable {

    public TextField[][] txtArray = new TextField[9][9];
    public Button[] btnArray = new Button[9];
    public static int numToAdd = 1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        btnArray[0] = b1;
        btnArray[1] = b2;
        btnArray[2] = b3;
        btnArray[3] = b4;
        btnArray[4] = b5;
        btnArray[5] = b6;
        btnArray[6] = b7;
        btnArray[7] = b8;
        btnArray[8] = b9;
        
        
                
                
        txtArray[0][0] = t00;       
        txtArray[0][1] = t10;
        txtArray[0][2] = t20;
        txtArray[0][3] = t30;
        txtArray[0][4] = t40;
        txtArray[0][5] = t50;
        txtArray[0][6] = t60;
        txtArray[0][7] = t70;
        txtArray[0][8] = t80;
        
        txtArray[1][0] = t01;       
        txtArray[1][1] = t11;
        txtArray[1][2] = t21;
        txtArray[1][3] = t31;
        txtArray[1][4] = t41;
        txtArray[1][5] = t51;
        txtArray[1][6] = t61;
        txtArray[1][7] = t71;
        txtArray[1][8] = t81;
        
        txtArray[2][0] = t02;       
        txtArray[2][1] = t12;
        txtArray[2][2] = t22;
        txtArray[2][3] = t32;
        txtArray[2][4] = t42;
        txtArray[2][5] = t52;
        txtArray[2][6] = t62;
        txtArray[2][7] = t72;
        txtArray[2][8] = t82;
        
        txtArray[3][0] = t03;       
        txtArray[3][1] = t13;
        txtArray[3][2] = t23;
        txtArray[3][3] = t33;
        txtArray[3][4] = t43;
        txtArray[3][5] = t53;
        txtArray[3][6] = t63;
        txtArray[3][7] = t73;
        txtArray[3][8] = t83;
        
        txtArray[4][0] = t04;       
        txtArray[4][1] = t14;
        txtArray[4][2] = t24;
        txtArray[4][3] = t34;
        txtArray[4][4] = t44;
        txtArray[4][5] = t54;
        txtArray[4][6] = t64;
        txtArray[4][7] = t74;
        txtArray[4][8] = t84;
        
        txtArray[5][0] = t05;       
        txtArray[5][1] = t15;
        txtArray[5][2] = t25;
        txtArray[5][3] = t35;
        txtArray[5][4] = t45;
        txtArray[5][5] = t55;
        txtArray[5][6] = t65;
        txtArray[5][7] = t75;
        txtArray[5][8] = t85;
        
        txtArray[6][0] = t06;       
        txtArray[6][1] = t16;
        txtArray[6][2] = t26;
        txtArray[6][3] = t36;
        txtArray[6][4] = t46;
        txtArray[6][5] = t56;
        txtArray[6][6] = t66;
        txtArray[6][7] = t76;
        txtArray[6][8] = t86;
        
        txtArray[7][0] = t07;       
        txtArray[7][1] = t17;
        txtArray[7][2] = t27;
        txtArray[7][3] = t37;
        txtArray[7][4] = t47;
        txtArray[7][5] = t57;
        txtArray[7][6] = t67;
        txtArray[7][7] = t77;
        txtArray[7][8] = t87;
        
        txtArray[8][0] = t08;       
        txtArray[8][1] = t18;
        txtArray[8][2] = t28;
        txtArray[8][3] = t38;
        txtArray[8][4] = t48;
        txtArray[8][5] = t58;
        txtArray[8][6] = t68;
        txtArray[8][7] = t78;
        txtArray[8][8] = t88;
        
        
    }

    //alternate method to initialize the game with either new game or load game
    public void doInitialSetup(){
        
        setActionsForInputBtns();
        setActionsForNumberButtons();
        lblResult.setText("New Game Loaded \n"
                + "To enter a value in the grid\n"
                + "Click on a numbered button\n"
                + "Then click on a textField in \n"
                + "the grid to put the number there!");
        
        if(SudokuLogic.isNewGame){
            System.out.println("new game is true");
            fillNewSudokuGrid();
        }
        else{
            System.out.println("load game opened");
            fillSavedSudokuGrid();
        }
    }
    
    //method which will help the user fill up the nos faster
    //User will click on a btn with a number and then that number will be entered into that field
    public void clickSelectAdd(int row, int col){
        txtArray[row][col].setText(""+numToAdd);
        System.out.println("clickSelectAdd called for row col " + row + "," + col);
    }
    
    //to set up the on action for all the number adding btns based on clickSelectAdd
    public void setActionsForNumberButtons(){
     System.out.println("setActionsforNumberButtons was called");
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                int c = col;
                int r = row;
                txtArray[row][col].setOnMousePressed(e -> {clickSelectAdd(r, c);});
            }
        }
    }
    
    @FXML
    private Button b1;
    
    @FXML
    private Button b2;
    
    @FXML
    private Button b3;
    
    @FXML
    private Button b4;
    
    @FXML
    private Button b5;
    
    @FXML
    private Button b6;
    
    @FXML
    private Button b7;
    
    @FXML
    private Button b8;
    
    @FXML
    private Button b9;
    
   
    
    
    
    
    
     @FXML
    private TextField t50;

    @FXML
    private TextField t52;

    @FXML
    private TextField t51;

    @FXML
    private TextField t10;

    @FXML
    private TextField t54;

    @FXML
    private TextField t53;

    @FXML
    private TextField t12;

    @FXML
    private TextField t56;

    @FXML
    private TextField t11;

    @FXML
    private TextField t55;

    @FXML
    private TextField t14;

    @FXML
    private TextField t58;

    @FXML
    private TextField t13;

    @FXML
    private TextField t57;

    @FXML
    private TextField t16;

    @FXML
    private TextField t15;

    @FXML
    private TextField t18;

    @FXML
    private TextField t17;

    @FXML
    private TextField t61;

    @FXML
    private TextField t60;

    @FXML
    private TextField t63;

    @FXML
    private TextField t62;

    @FXML
    private TextField t21;

    @FXML
    private TextField t65;

    @FXML
    private TextField t20;

    @FXML
    private TextField t64;

    @FXML
    private TextField t23;

    @FXML
    private TextField t67;

    @FXML
    private TextField t22;

    @FXML
    private TextField t66;

    @FXML
    private TextField t25;

    @FXML
    private TextField t24;

    @FXML
    private TextField t68;

    @FXML
    private TextField t27;

    @FXML
    private TextField t26;

    @FXML
    private TextField t28;

    @FXML
    private TextField t70;

    @FXML
    private TextField t72;

    @FXML
    private TextField t71;

    @FXML
    private TextField t30;

    @FXML
    private TextField t74;

    @FXML
    private TextField t73;

    @FXML
    private TextField t32;

    @FXML
    private TextField t76;

    @FXML
    private TextField t31;

    @FXML
    private TextField t75;

    @FXML
    private TextField t34;

    @FXML
    private TextField t78;

    @FXML
    private TextField t33;

    @FXML
    private TextField t77;

    @FXML
    private TextField t36;

    @FXML
    private TextField t35;

    @FXML
    private TextField t38;

    @FXML
    private TextField t37;

    @FXML
    private TextField t81;

    @FXML
    private TextField t80;

    @FXML
    private TextField t83;

    @FXML
    private TextField t82;

    @FXML
    private TextField t41;

    @FXML
    private TextField t85;

    @FXML
    private TextField t40;

    @FXML
    private TextField t84;

    @FXML
    private TextField t43;

    @FXML
    private TextField t87;

    @FXML
    private TextField t42;

    @FXML
    private TextField t86;

    @FXML
    private TextField t01;

    @FXML
    private TextField t45;

    @FXML
    private TextField t00;

    @FXML
    private TextField t44;

    @FXML
    private TextField t88;

    @FXML
    private TextField t03;

    @FXML
    private TextField t47;

    @FXML
    private TextField t02;

    @FXML
    private TextField t46;

    @FXML
    private TextField t05;

    @FXML
    private TextField t04;

    @FXML
    private TextField t48;

    @FXML
    private TextField t07;

    @FXML
    private TextField t06;

    @FXML
    private TextField t08;
    
    @FXML
    private Label lblResult;
    
    
    public void setActionsForInputBtns(){
        for(int i = 0; i < 9 ; i++){
            final int j = i + 1;
            btnArray[i].setOnAction(e -> {
                numToAdd = j;
                System.out.println("numToAdd is " + numToAdd);
            });
        }
    }
    
    @FXML
    public void showSudokuOptions(){
        JavaProject.showSudokuOptions();
        System.out.println("Sudoku Game Options Window opened");
    }
    
    //to fill the starting nos in the sudoku grid on the UI
    @FXML
    public void fillNewSudokuGrid(){
        SudokuLogic.readNewSudoku();
        String[][] array = SudokuLogic.sudokuGrid;
          
          for(int row = 0; row < 9; row++){
              for(int col = 0; col < 9; col++){
                  txtArray[row][col].setText(array[row][col]);
                  
                  if(!array[row][col].equals("")){
                    txtArray[row][col].setDisable(true);
                    txtArray[row][col].setStyle("-fx-text-fill:green;");
                  }else{
                    txtArray[row][col].setDisable(false);
                    txtArray[row][col].setStyle("-fx-text-fill:orange;");
                  }
              }
          }
        lblResult.setText("New Game Loaded \n"
                + "To enter a value in the\n"
                + "grid. Click on a numbered\n"
                + "button. Then click on a\n"
                + "textField in the grid to\n put the number there!");
          
    }
    
    //to load saved game
    //this changes the global sudoku grid to the saved game
    @FXML
    public void fillSavedSudokuGrid(){
        SudokuLogic.readSudokuFile(JavaProject.currentPlayer.getUserFileName());
        String[][] array = SudokuLogic.sudokuGrid;
          
          for(int row = 0; row < 9; row++){
              for(int col = 0; col < 9; col++){
                  txtArray[row][col].setText(array[row][col]);
              }
          } 
        lblResult.setText("Saved Game Loaded");

    }
    
    
    //method to save the user gameplay into the sudokugrid array
    @FXML
    public void saveSudouku(){
        
        SudokuLogic.sudokuGrid = getLatestSudokuUI();   
        System.out.println("The saved sudoku game is ");
        SudokuLogic.printPrettySudoku();
        SudokuLogic.saveGame();
        lblResult.setText("Game Saved");
        

    }
    
    //returns a 2d array containing the user input
    //it does not save it to the sudouku grid array
    public String[][] getLatestSudokuUI(){
        String[][] array  = new String[9][9];
             for(int row = 0; row < 9; row++){
              for(int col = 0; col < 9; col++){
                 array[row][col] = txtArray[row][col].getText();
              }
          }  
           return array;   
    }
    
    public boolean isSudokuCorrect(){
        boolean isCorrect = true;
        boolean doesRowContains[];
        int intValue;
        String array[][] = getLatestSudokuUI();
        
        for(int row = 0; row < 9; row++){
            doesRowContains = new boolean[9];
              for(int col = 0; col < 9; col++){
                 try{
                     intValue = Integer.parseInt(txtArray[row][col].getText());
                     doesRowContains[intValue - 1 ] = true;
                 }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                     System.out.println(e);
                     return false;
                 }
              }
                 //if doesRowCOntain array contains a single false then the sudoku is wrong
                 for(boolean a: doesRowContains){
                     if(a == false)
                         return false;
                 }
        }
        return true;
    }
    
    @FXML
    public void checkSudoku(){
        if(isSudokuCorrect()){
          System.out.println("Sudoku is CORRECT");
          lblResult.setText("CORRECT");
        }
        else{
          System.out.println("Sudoku is INCORRECT");
          lblResult.setText("INCORRECT");
        }
    }
    
    
    
}
