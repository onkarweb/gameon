/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class LoadController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        progressBar.progressProperty().addListener(new ChangeListener<Number>() {

         
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                
                if(t1.doubleValue()==1){
                    JavaProject.showWelcome();
                }
            }

            

        });
    }    
    
    @FXML
    private ProgressBar progressBar;
    
    @FXML
    private ProgressIndicator prgIndicator;
    
 
            
    public void updateProgressBar(){
        
    Task task = createWorker(5);
    progressBar.progressProperty().unbind();
    progressBar.progressProperty().bind(task.progressProperty());
    prgIndicator.progressProperty().unbind();
    prgIndicator.progressProperty().bind(task.progressProperty());
    new Thread(task).start();
     
    
    }
    
    public Task createWorker(int seconds) {
    return new Task() {
      @Override
      protected Object call() throws Exception {
        for (int i = 0; i < seconds; i++) {
          Thread.sleep(1000);
          updateMessage("1000 milliseconds");
          updateProgress(i + 1, seconds);
        }
        return true;
      }
      
      
       
    };
  }
    
    
}
