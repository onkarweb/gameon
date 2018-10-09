/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Onkar
 */
public class PlayerLogic {
    
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    
    //method to check if the username exists
    //if it exists then it returns the index of the user in players arraylist
    //return -1 if player not found
    public static int indexOfPlayer(String username, String password){
        readPlayersFile();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getUsername().equals(username)){
                return i;
            }
        }
        //if the username didn't match then return -1
        return -1;
    }
    
    //to validate the login
    //returns 1: if the username match
    //returns -1: if username not found
    //returns 2: if username and password match
    //if something else happened then return -2
    public static int loginPlayer(String username, String password){
        int indexOfPlayer = indexOfPlayer(username, password);
        if(indexOfPlayer == -1)
           return -1;
        
        if(players.get(indexOfPlayer).getUsername().equals(username))
            if(players.get(indexOfPlayer).getPassword().equals(password))
                return 2;
            else
                return 1;
        //if something went wrong return -2
        return -2;
           
    }
    
      //method to check if the username exists
    //if it exists then it returns the index of the user in players arraylist
    //return -1 if player not found
    public static int indexOfPlayer(String username){
        readPlayersFile();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getUsername().equals(username)){
                return i;
            }
        }
        //if the username didn't match then return -1
        return -1;
    }
  
    
    
    
    //method to add new players to the players file
    public static void addPlayer(Player player){
         try {
    //identify the file
    File file = new File("Players.txt");
    
    //if the file doesn't exist then stop
    if(!file.exists())
            file.createNewFile();
    
    //open the file
    FileWriter fr = new FileWriter(file.getAbsoluteFile(), true);
    BufferedWriter br = new BufferedWriter(fr);
    
    //write to file
    br.write(player.toFileString());
    br.newLine();
   
    
    //close the file
    br.close();
    
    
    
    } catch(IOException ex) {
        System.out.println(ex);
    }
    }
    
    //method to rewrite the entire file again i.e. write the arraylist to that
    public static void writePlayersComplete(ArrayList<Player> players){
         try {
    //identify the file
    File file = new File("Players.txt");
    
    //if the file doesn't exist then stop
    if(!file.exists())
            file.createNewFile();
    
    //open the file
    FileWriter fr = new FileWriter(file.getAbsoluteFile());
    BufferedWriter br = new BufferedWriter(fr);
    
    //write to file
    
    for(Player p : players){
        br.write(p.toFileString());
        br.newLine();
    }
    
    //close the file
    br.close();
    
    
    } catch(IOException ex) {
        System.out.println(ex);
    }
         
         
    }
    
    
    //method to read the Players file
    //And populate the players arraylist
    public static void readPlayersFile(){
        //resetting the players arraylist everytime I need to read the file
        players = new ArrayList<Player>();
        
        try {
    //identify the new game data file
    File file = new File("Players.txt");
    
    //if the file doesn't exist then stop
    if(!file.exists())
            throw new FileNotFoundException();
    
    //open the file
    FileReader fr = new FileReader(file.getAbsoluteFile());
    BufferedReader br = new BufferedReader(fr);
    
    //start reading the file
    String s = "";
    while((s = br.readLine()) != null){
        String[] lineArray = s.split(":");
        String username = lineArray[0];
        String password = lineArray[1];
        int highScore = Integer.parseInt(lineArray[2]);
        String userFileName = lineArray[3];
        
        Player player = new Player(username, password, highScore, userFileName);
        players.add(player);
    }
    
    System.out.println("");
    //close the file
    br.close();
    
    
    
    } catch(IOException ex) {
        System.out.println(ex);
    }
    
    }
    
}
