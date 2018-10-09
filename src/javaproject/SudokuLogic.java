/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Onkar
 */
public class SudokuLogic {
    
    //array to store the sudoku grid numbers
    public static String[][] sudokuGrid = new String[9][9]; 
    
    //boolean variable to tell if a new game is loaded
    public static boolean isNewGame;
    
    
//method to return a random newGame filename
private static String randomFileName(){
        int randomNum = (int)(Math.random()*10 + 1);
        String fileName =  "./newGameFiles/newSudoku" + randomNum + ".txt";
        System.out.println("The chosen new game file is " + fileName);
        return fileName;
}

public static void readNewSudoku(){
    readSudokuFile(randomFileName());
}
    


//method to read sudoku game data from a file
public static void readSudokuFile(String filename){
    
    
   try {
    //identify the new game data file
    File file = new File(filename);
    
    //if the file doesn't exist then stop
    if(!file.exists())
            throw new FileNotFoundException();
    
    //open the file
    FileReader fr = new FileReader(file.getAbsoluteFile());
    BufferedReader br = new BufferedReader(fr);
    
    //start reading the file
    String s = "";
    int row = 0;
    while((s = br.readLine()) != null){
        String[] lineArray = s.split("");
        fillSudokuRow(lineArray, row++);
    }
    
    //checking the file
    printActualSudoku();
    System.out.println("The sudoku with 0 at blank spaces is");
    printPrettySudoku();
    
    //close the file
    br.close();
    
    
    
    } catch(IOException ex) {
        System.out.println(ex);
    }
    
}




//to save the sudoku game to a file from the sudoku grid
    public static void saveGame(){
        
        try {
    //identify the file
    File file = new File(JavaProject.currentPlayer.getUserFileName());
    
    //if the file doesn't exist then stop
    if(!file.exists())
            file.createNewFile();
    
    //open the file
    FileWriter fr = new FileWriter(file.getAbsoluteFile());
    BufferedWriter br = new BufferedWriter(fr);
    
   
    for(int row = 0; row < 9; row++){
        for(int col = 0; col < 9; col++){
            String value = sudokuGrid[row][col];
            if(value.equals(""))
                value = "0";
            
            br.write(value);
        }
        br.newLine();
            
    }

    
    //close the file
    br.close();
    
    
    
    } catch(IOException ex) {
        System.out.println(ex);
    }
    }

//to fill a particular row of the sudoku grid with an array of 9 nos
    public static void fillSudokuRow(String[] array, int row){
        
//        System.arraycopy(array, 0, sudokuGrid[row], 0, 9);
        for(int i = 0; i < 9; i++){
            String value = array[i];
            if(value.equals("0"))
                value = "";
            
           sudokuGrid[row][i] = value ;
        }
          
    }
    
    //method to print an int[][] sudokuGrid on the console
    public static void printActualSudoku(){
        for(String[] r: sudokuGrid){
            for(String c: r ){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    
    public static void printPrettySudoku(){
        for(String[] r: sudokuGrid){
            for(String c: r ){
                if(c.equals(""))
                    c = "0";
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    
    
}