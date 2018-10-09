/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class TicTacToeController implements Initializable {
    
    private static int turn = 0;
    public static Button[] btnArray;
    public static String[] strArray = new String[9];
    public static boolean someOneHasWon = false;
    public static int currentPlayerTotalScore = -1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lblResult.setText("LOL");
        btnArray = new Button[9];
        btnArray[0] = btn0;
        btnArray[1] = btn1;
        btnArray[2] = btn2;
        btnArray[3] = btn3;
        btnArray[4] = btn4;
        btnArray[5] = btn5;
        btnArray[6] = btn6;
        btnArray[7] = btn7;
        btnArray[8] = btn8;
        
        //to setup the initial blank photos
        makeGridBlank();
        resetButtonsActionHandler(); // this will set up the action event handler for all btns
         
    }   
    
    
    @FXML
    Button btn0;
    
    @FXML
    Button btn1;
    
    @FXML
    Button btn2;
    
    @FXML
    Button btn3;
    
    @FXML
    Button btn4;
    
    @FXML
    Button btn5;
 
    @FXML
    Button btn6;
    
    @FXML
    Button btn7;
    
    @FXML
    Button btn8;
    
    @FXML
    Label lblScore;
    
    @FXML
    GridPane grid;
    
    @FXML
    Label lblHeading;
    
    @FXML
    private Label lblResult;
    
    @FXML
    private ImageView replayBtn;   
    
    public void showtttOptions(){
        JavaProject.showtttOptions();
        
      
      
        System.out.println("Initial size "+ PlayerLogic.players.size() );
       
        int index = PlayerLogic.indexOfPlayer(JavaProject.currentPlayer.getUsername());
        System.out.println("The index of the current Player is " + index );
        PlayerLogic.players.remove(index);
        
        System.out.println("After size "+ PlayerLogic.players.size() );
        System.out.println("After " + PlayerLogic.players);


        JavaProject.currentPlayer.setHighScore(currentPlayerTotalScore);
        PlayerLogic.players.add(JavaProject.currentPlayer);
        
        PlayerLogic.writePlayersComplete(PlayerLogic.players);
    }
    
    //to change the heading label everytime the player navigates from tttOptions to tttGame
    public void changeHeading(){
       currentPlayerTotalScore = JavaProject.currentPlayer.getHighScore(); 
       lblScore.setText(""+currentPlayerTotalScore);
       
        if(TicTacToeLogic.isMultiplayer)
            lblHeading.setText("Tic Tac Toe 2 Player");
        else
            lblHeading.setText("Tic Tac Toe vs PC");
    }
    
    //to make the replay btn rotate
    public void makeReplayBtnRotate(){
    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.8), replayBtn);
    rotateTransition.setFromAngle(0);
    rotateTransition.setToAngle(360);
    rotateTransition.play();
    }     
            
    //to set all the buttons to blank images on reset
    //to be used in starting and on every reset
    public void makeGridBlank(){
        for(Button b : btnArray){
            b.setText("");
            Image img = new Image("images/blank.png");
            ImageView imv = new ImageView(img);
            imv.setFitHeight(135);
            imv.setFitWidth(170);
            b.setGraphic(imv);
        }
    }
    
    //to reset everything
    @FXML
    public void reset(){
        strArray = new String[9];
        makeGridBlank();
        turn = 0;
        resetButtonsActionHandler();
        lblResult.setText("Let's see who wins");
        someOneHasWon = false;
        System.out.println("\nTHE GAME HAS BEEN RESET \n");
        makeReplayBtnRotate();
    }
    
    //method to reset the action handlers to image changers on reset
    public void resetButtonsActionHandler(){
        for(int i = 0; i < btnArray.length; i++){
            final int j = i;     //did this to meet the requirement of final variable here
            btnArray[j].setOnAction(e -> {changeImageGeneralClickHandler(j);});
        }
    }
    
    //method to insert O by the computer at the given index
    public void insertO(int tgtIndex){
        if(tgtIndex != -1 && tgtIndex < 9 && tgtIndex >= 0 && strArray[tgtIndex]==null){
            
            Image img = new Image("images/O.png");
            ImageView imv = new ImageView(img);
            imv.setFitHeight(135);
            imv.setFitWidth(170);
            btnArray[tgtIndex].setGraphic(imv);
            
            strArray[tgtIndex] = "O";
            btnArray[tgtIndex].setOnAction(e->{System.out.println("Button already occupied by O");});
            System.out.println(Arrays.toString(strArray));

        
        turn++;
        }
    }
    
    //to check win status
    //will be used in everyBtn method and insertO but only includes the checkWin status
    public void handleWinStatus(){
        boolean hasXWon = checkWin("X");
        boolean hasOWon = checkWin("O");
        
        System.out.println("CheckWin for X is " + hasXWon);
        System.out.println("CheckWin for O is " + hasOWon);
        
        if(isGridFull()){
            lblResult.setText("It's a Tie");
        }
        
        //code to stop the game when someone wins
        if(hasXWon){
            someOneHasWon = true;
            lblResult.setText("Player X has won");
            currentPlayerTotalScore++;
            lblScore.setText(""+currentPlayerTotalScore);
            disableGrid();
        }
        if(hasOWon){
            someOneHasWon = true;
            if(TicTacToeLogic.isMultiplayer){
                lblResult.setText("Player O has won");}
            
            else{
                lblResult.setText("Computer Won");
            }
                disableGrid();   
        }
        
    }
    
    //to handle the insertion of O automatically
    //uses insertO method
    public void handleOInsertion(){
        int tgtIndex = expectedIndexOWinning();
        System.out.println("expectedIndexOWinning is " + tgtIndex);
            if(tgtIndex == -1){
                tgtIndex = expectedIndex();
                System.out.println("expectedIndex is " + tgtIndex);
            }
            if(tgtIndex == -1)
                tgtIndex = randomIndex();
            System.out.println("The final expected index for O is " + tgtIndex );
            if(tgtIndex != -1 && strArray[tgtIndex] == null){
            System.out.println("O inserted automatically at " + tgtIndex);
            insertO(tgtIndex);
            }
    }
           
    //code to run at the end of action handler of every button in grid
    public void everyBtn(){
        handleWinStatus();
        //to stop O insertion if the X player has won
        if(!someOneHasWon){
        if(isGridFull()){
            System.out.println("Exiting the evryBtn method as the grid is full");
            return;
        }
        System.out.println(Arrays.toString(strArray));
        if(!TicTacToeLogic.isMultiplayer){ //line that controls the multiplayer and computer opponent
            handleOInsertion();
        }handleWinStatus();
        }
        
    }
    
    //method to set the onAction of all the buttons to nothing
    public void disableGrid(){
        for(Button b: btnArray){
            b.setOnAction(e-> {});
        }
    }
    
    //to check if the strArray is full
    public boolean isGridFull(){
        for(String a: strArray){
            if(a == null)
                return false;
        }
        return true;
    }
    
    //to return a random index incase none on the expectedIndex methods work
    public int randomIndex(){
        System.out.println("The random Index method was called");
        if(isGridFull()){
            System.out.println("Exiting the randomMethod as the strArray is FUll :(");
            return -1;
        }
        int randomIndex = (int)(Math.random() * 9);
        while(strArray[randomIndex] != null){
            randomIndex = (int)(Math.random() * 9);
            System.out.println(" Temporary Random index is " + randomIndex);
        }
        return randomIndex;
    }
    
    //method to find the expected index in case O is winning then it should place O at the winning position
    public int expectedIndexOWinning(){
        
         //if difficulty level is 1 then simply return -1 which will force the insertO method to
        //use a random index
        if(TicTacToeLogic.difficultyLevel == 1)
            return -1;
        
        boolean[] xIndices = letterIndicesArray("O");
        int tgtIndex = -1;
        
        if((xIndices[0] && xIndices[4] || xIndices[2] && xIndices[5] || xIndices[6] && xIndices[7]) && strArray[8] == null )
           tgtIndex = 8;
   else if((xIndices[1] && xIndices[4] || xIndices[6] && xIndices[8]) && strArray[7] == null )
           tgtIndex = 7;
   else if((xIndices[2] && xIndices[4] || xIndices[0] && xIndices[3] || xIndices[7] && xIndices[8]) && strArray[6] == null )
           tgtIndex = 6;
   else if((xIndices[3] && xIndices[4] || xIndices[2] && xIndices[8] ) && strArray[5] == null)
           tgtIndex = 5;
   else if((xIndices[5] && xIndices[4] || xIndices[0] && xIndices[6] ) && strArray[3] == null)
           tgtIndex = 3;
   else if((xIndices[6] && xIndices[4] || xIndices[0] && xIndices[1] || xIndices[5] && xIndices[8]) && strArray[2] == null )
           tgtIndex = 2;
   else if((xIndices[7] && xIndices[4] || xIndices[2] && xIndices[0]) && strArray[1] == null )
           tgtIndex = 1;
   else if((xIndices[8] && xIndices[4] || xIndices[3] && xIndices[6] || xIndices[1] && xIndices[2] ) && strArray[0] == null)
           tgtIndex = 0;
   else if((xIndices[0] && xIndices[8] || xIndices[2] && xIndices[6] || xIndices[1] && xIndices[7]|| xIndices[3] && xIndices[5]) && strArray[4] == null )
           tgtIndex = 4;
        
        return tgtIndex;
        
    }
    
    
   //method to find the expected index to insert O
    public int expectedIndex(){
        
        //if difficulty level is 1 then simply return -1 which will force the insertO method to
        //use a random index
        if(TicTacToeLogic.difficultyLevel == 1)
            return -1;
        
        boolean[] xIndices = letterIndicesArray("X");
  //code to put X in center if its empty in the first move
  //if its occupied by first turn of user then we occupy corners only
   if(turn == 1 && TicTacToeLogic.difficultyLevel != 1){
   if(!xIndices[4])
     return 4;
    //code to randomly return any index out of 6,2,0,8 on the first turn of computer
    //makes the experience more real
    int[] array = {6,2,0,8};
        int randomNum = (int)(Math.random()*4);
        if(!xIndices[randomNum])
            return array[randomNum];
  }
   //condition to deal when X is not entered in center and then creates a trap by putting x
  //on two opp corners
  //the second if condition ensures that it only works when X is on 2 opp corners after 2 userAttempt
  if( turn == 3 && !xIndices[4] && TicTacToeLogic.difficultyLevel == 3 ){
    if(xIndices[0]  && xIndices[8] || xIndices[6]  && xIndices[2]){
   if(!xIndices[1])
      return 1;
   else if(!xIndices[3])
      return 3;
   else if(!xIndices[5])
      return 5;
   else if(!xIndices[7])
      return 7;
  }
  }
  
  
        
        int tgtIndex = -1;
        
        if((xIndices[0] && xIndices[4] || xIndices[2] && xIndices[5] || xIndices[6] && xIndices[7]) && strArray[8] == null )
           tgtIndex = 8;
   else if((xIndices[1] && xIndices[4] || xIndices[6] && xIndices[8]) && strArray[7] == null )
           tgtIndex = 7;
   else if((xIndices[2] && xIndices[4] || xIndices[0] && xIndices[3] || xIndices[7] && xIndices[8]) && strArray[6] == null )
           tgtIndex = 6;
   else if((xIndices[3] && xIndices[4] || xIndices[2] && xIndices[8] ) && strArray[5] == null)
           tgtIndex = 5;
   else if((xIndices[5] && xIndices[4] || xIndices[0] && xIndices[6] ) && strArray[3] == null)
           tgtIndex = 3;
   else if((xIndices[6] && xIndices[4] || xIndices[0] && xIndices[1] || xIndices[5] && xIndices[8]) && strArray[2] == null )
           tgtIndex = 2;
   else if((xIndices[7] && xIndices[4] || xIndices[2] && xIndices[0]) && strArray[1] == null )
           tgtIndex = 1;
   else if((xIndices[8] && xIndices[4] || xIndices[3] && xIndices[6] || xIndices[1] && xIndices[2] ) && strArray[0] == null)
           tgtIndex = 0;
   else if((xIndices[0] && xIndices[8] || xIndices[2] && xIndices[6] || xIndices[1] && xIndices[7]|| xIndices[3] && xIndices[5]) && strArray[4] == null )
           tgtIndex = 4;
        
        //code to ensure that O is put on corner after the second user turn when X is center on first turn
  if( turn == 3 && xIndices[4] && tgtIndex == -1 && TicTacToeLogic.difficultyLevel == 3){
  
    if(!xIndices[2] && strArray[2] == null)
      return 2;
   else if(!xIndices[6] && strArray[6] == null)
      return 6;
   else if(!xIndices[8] && strArray[8] == null)
      return 8;
   else if(!xIndices[0] && strArray[0] == null)
      return 0;
  }
        
        
        return tgtIndex;
        
    }
    
    //to replace the winning sequence with green images
    //here letter is the name of the image
    public void replaceWithGreenImages(String imageName, int i1, int i2, int i3){
            changeImage(imageName, i1);
            changeImage(imageName, i2);
            changeImage(imageName, i3);
    }
    
    //method to check if someone has won
    public boolean checkWin(String letter){
        String imageName = "";
        if(letter.equals("X"))
            imageName = "greenX";
        if(letter.equals("O"))
            imageName = "greenO";
        System.out.println("imageName is " + imageName);
        
        boolean hasWon = true;
     boolean[] booleanArray = letterIndicesArray(letter);
       
          if(booleanArray[0] && booleanArray[1] && booleanArray[2] ){
              replaceWithGreenImages(imageName, 0, 1, 2);
              return true;}
     else if(booleanArray[3] && booleanArray[4] && booleanArray[5] ){
              replaceWithGreenImages(imageName, 3, 4, 5);
              return true;}
     else if(booleanArray[6] && booleanArray[7] && booleanArray[8] ){
              replaceWithGreenImages(imageName, 6, 7, 8);
              return true;}
     else if(booleanArray[0] && booleanArray[3] && booleanArray[6] ){
              replaceWithGreenImages(imageName, 0, 3, 6);
              return true;}
     else if(booleanArray[1] && booleanArray[4] && booleanArray[7] ){
              replaceWithGreenImages(imageName, 1, 4, 7);
              return true;}
     else if(booleanArray[2] && booleanArray[5] && booleanArray[8] ){
              replaceWithGreenImages(imageName, 2, 5, 8);
              return true;}
     else if(booleanArray[0] && booleanArray[4] && booleanArray[8] ){
              replaceWithGreenImages(imageName, 0, 4, 8);
              return true;}
     else if(booleanArray[2] && booleanArray[4] && booleanArray[6] ){
              replaceWithGreenImages(imageName, 2, 4, 6);
              return true;}  
     else
        return false;
    }
    
    
    //method to return the boolean array for a specific letter
    //the array contains true for every occurence of that letter
    public static boolean[] letterIndicesArray(String letter){
        boolean[] letterArray = new boolean[9];

        for(int i = 0; i < 9; i++){
            if(strArray[i] != null)
            if(strArray[i].equals(letter))
                letterArray[i] = true;
        }
        return letterArray;
    }
    
    //to put the the specified letter at the specified position in the grid
    public void changeImage(String letter, int index){
         Image img = new Image("images/"+letter+".png");
            ImageView imv = new ImageView(img);
            imv.setFitHeight(135);
            imv.setFitWidth(170);
            btnArray[index].setGraphic(imv);
            if(letter.equalsIgnoreCase("X") || letter.equalsIgnoreCase("O"))
            strArray[index] = letter;
    }
    
    //general onclick method for every btn
    public void changeImageGeneralClickHandler(int index){
         System.out.println("turn is " + turn);
        //let's always give the first turn to the user and they will have X to make                
        if(turn % 2 == 0){
            changeImage("X", index);
        }
        if(turn % 2 == 1){
            changeImage("O", index);
        }
        turn++;
        everyBtn();
        
          btnArray[index].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
    
    }
    
    
    //*************BUTTONS ONCLICK METHODS BELOW ******************************
    
//    @FXML
//    public void changeImage0(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            changeImage("X",0);
//        }
//        if(turn % 2 == 1){
//            changeImage("O",0);
//        }
//        turn++;
//        everyBtn();
//        
//          btnArray[0].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//    }
//    
//     @FXML
//    public void changeImage1(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[1].setGraphic(imv);
//            
//            strArray[1] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[1].setGraphic(imv);
//            
//            strArray[1] = "O";
//        }
//        turn++;
//        everyBtn();
//          btnArray[1].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//    }
//    
//     @FXML
//    public void changeImage2(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[2].setGraphic(imv);
//            
//            strArray[2] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[2].setGraphic(imv);
//            
//            strArray[2] = "O";
//        }
//        turn++; 
//        everyBtn();
//          btnArray[2].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//    }
//    
//     @FXML
//    public void changeImage3(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[3].setGraphic(imv);
//            
//            strArray[3] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[3].setGraphic(imv);
//            
//            strArray[3] = "O";
//        }
//        turn++;
//        everyBtn();
//        btnArray[3].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//    }
//    
//     @FXML
//    public void changeImage4(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[4].setGraphic(imv);
//            
//            strArray[4] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[4].setGraphic(imv);
//            
//            strArray[4] = "O";
//        }
//        turn++;
//        everyBtn();
//        btnArray[4].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//
//    }
//    
//     @FXML
//    public void changeImage5(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[5].setGraphic(imv);
//            
//            strArray[5] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[5].setGraphic(imv);
//            
//            strArray[5] = "O";
//        }
//        turn++; 
//        everyBtn();
//        btnArray[5].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//        
//    }
//    
//     @FXML
//    public void changeImage6(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[6].setGraphic(imv);
//            
//            strArray[6] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[6].setGraphic(imv);
//            
//            strArray[6] = "O";
//        }
//        turn++; 
//        everyBtn();
//        btnArray[6].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//        
//    }
//    
//     @FXML
//    public void changeImage7(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[7].setGraphic(imv);
//            
//            strArray[7] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[7].setGraphic(imv);
//            
//            strArray[7] = "O";
//        }
//        turn++;
//        everyBtn();
//        btnArray[7].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//       
//    }
//    
//     @FXML
//    public void changeImage8(){
//
//        System.out.println("turn is " + turn);
//        //let's always give the first turn to the user and they will have X to make                
//        if(turn % 2 == 0){
//            Image img = new Image("images/x.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[8].setGraphic(imv);
//            
//            strArray[8] = "X";
//        }
//        if(turn % 2 == 1){
//            Image img = new Image("images/o.png");
//            ImageView imv = new ImageView(img);
//            imv.setFitHeight(135);
//            imv.setFitWidth(170);
//            btnArray[8].setGraphic(imv);
//            
//            strArray[8] = "O";
//        }
//        turn++;
//        everyBtn();
//        btnArray[8].setOnAction(e -> {System.out.println("Button already pressed");} );  //to allow clicking once
//
//    }
    
}
