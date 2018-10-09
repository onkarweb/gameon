/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Onkar
 */
public class JavaProject extends Application {
        
      public static Player currentPlayer;
        
        static Stage stage1 = new Stage();  // sudokuOptions
        static Stage stage2 = new Stage();  // sudokuGame
        static Stage stage3 = new Stage();  // registration
        static Stage stage4 = new Stage();  // login
        static Stage stage5 = new Stage();  // welcome 
        static Stage stage6 = new Stage();  // tictacToe game
        static Stage stage7 = new Stage();  // ttt options
        static Stage stage8 = new Stage();  // hall of fame
        static Stage stage9 = new Stage();  // Loading
        
        
     public static SudokuOptionsController c1;
     public static SudokuTwoController c2;
     public static RegistrationController c3;
     public static LoginController c4;
     public static WelcomeController c5;
     public static TicTacToeController c6;
     public static TttOptionsController c7;
     public static HallofFameController c8;
     public static LoadController c9;

        
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root2 = FXMLLoader.load(getClass().getResource("SudokuTwo.fxml"));
//        Parent root1 = FXMLLoader.load(getClass().getResource("SudokuOptions.fxml"));

        FXMLLoader r1 = new FXMLLoader(getClass().getResource("SudokuOptions.fxml"));
        FXMLLoader r2 = new FXMLLoader(getClass().getResource("SudokuTwo.fxml"));
        FXMLLoader r3 = new FXMLLoader(getClass().getResource("Registration.fxml"));
        FXMLLoader r4 = new FXMLLoader(getClass().getResource("Login.fxml"));
        FXMLLoader r5 = new FXMLLoader(getClass().getResource("Welcome.fxml"));
        FXMLLoader r6 = new FXMLLoader(getClass().getResource("TicTacToe.fxml"));
        FXMLLoader r7 = new FXMLLoader(getClass().getResource("tttOptions.fxml"));
        FXMLLoader r8 = new FXMLLoader(getClass().getResource("HallofFame.fxml"));
        FXMLLoader r9 = new FXMLLoader(getClass().getResource("load.fxml"));

        
        Parent root1 = r1.load();
        Parent root2 = r2.load();
        Parent root3 = r3.load();
        Parent root4 = r4.load();
        Parent root5 = r5.load();
        Parent root6 = r6.load();
        Parent root7 = r7.load();
        Parent root8 = r8.load();
        Parent root9 = r9.load();
        
        
        c1 = r1.getController();
        c2 = r2.getController();
        c3 = r3.getController();
        c4 = r4.getController();
        c5 = r5.getController();
        c6 = r6.getController();
        c7 = r7.getController();
        c8 = r8.getController();
        c9 = r9.getController();

        
        Scene scene1 = new Scene(root1);
        Scene scene2 = new Scene(root2);
        Scene scene3 = new Scene(root3);
        Scene scene4 = new Scene(root4);
        Scene scene5 = new Scene(root5);
        Scene scene6 = new Scene(root6);
        Scene scene7 = new Scene(root7);
        Scene scene8 = new Scene(root8);
        Scene scene9 = new Scene(root9);

        
        stage1.setScene(scene1);
        stage2.setScene(scene2);
        stage3.setScene(scene3);
        stage4.setScene(scene4);
        stage5.setScene(scene5);
        stage6.setScene(scene6);
        stage7.setScene(scene7);
        stage8.setScene(scene8);
        stage9.setScene(scene9);
        
        

        showLogin();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void playMusic(String musicName){
        String musicFile = "";
        if(musicName.equals("buttonpush")){
             musicFile = "buttonpush.mp3";     // For example
        }else if(musicName.equals("error"))
             musicFile = "error.mp3";
                
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
       
    }
    
    public static void showHallofFame(){
        playMusic("buttonpush");
        stage8.show();
        stage7.hide();
        stage5.hide();
        c8.displayTop3Players();
    }
    
    public static void showLoading(){
        playMusic("error");
        stage9.show();
        stage4.hide();
        stage5.hide();
        c9.updateProgressBar();
    }
    
    public static void showtttOptions(){
        playMusic("error");
        stage7.show();
        stage6.hide();
        stage5.hide();
    }
    
    public static void showtttGame(){
        playMusic("buttonpush");
        stage6.show();
        stage7.hide();
        stage5.hide();
        c6.changeHeading();
        c6.reset();
    }
    
    public static void showWelcome(){
        playMusic("buttonpush");        
        stage5.show();
        stage4.hide();
        stage1.hide();
        stage8.hide();
        stage7.hide();
        stage9.hide();
        c5.welcomeUserName();
    }
    
    public static void showLogin(){
        playMusic("buttonpush");        
        stage4.show();
        stage3.hide();
        stage5.hide();
        stage9.hide();
    }
    
    public static void showRegistration(){
        playMusic("buttonpush");        
        stage3.show();
        stage4.hide();
    }
    
    
    public static void showSudokuOptions(){
        playMusic("error");       
        stage1.show();
        stage2.hide();
        stage5.hide();
    }
    
    public static void showSudokuGame(){
        playMusic("buttonpush");
        c2.doInitialSetup();
        stage2.show();
        stage1.hide();
    }
    
}
