/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author AYMEN
 */
public class AccueilEventPane extends AnchorPane {
    
    public AccueilEventPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilEventPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @FXML
    private void initialize() {
    }
    
    @FXML
    private void getAuthentification() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthentificationPane.fxml"));

         Parent root = fxmlLoader.load();
         
         AuthentificationPane a=fxmlLoader.getController();
         
         
    }
}
