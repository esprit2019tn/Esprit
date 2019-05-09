/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class RecupererPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField email;

    @FXML
    private Label msgErreur;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    void confirmer(ActionEvent event) {

    }
    
}
