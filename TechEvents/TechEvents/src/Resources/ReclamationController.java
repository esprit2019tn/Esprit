/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author dhiae
 */
public class ReclamationController implements Initializable {

    @FXML
    private JFXButton btnValider;
    @FXML
    private JFXButton btnAnnuler;
    @FXML
    private Pane userPane;
    @FXML
    private Label userName;
    @FXML
    private JFXButton btnInscription;
    @FXML
    private JFXButton btnConnexion;
    @FXML
    private JFXButton btnDeconnexion;
    @FXML
    private Pane menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insertReclam(ActionEvent event) {
    }

    @FXML
    private void init(ActionEvent event) {
    }

    @FXML
    private void splitMenu(ActionEvent event) {
    }

    @FXML
    private void inscription(ActionEvent event) {
    }

    @FXML
    private void connexion(ActionEvent event) {
    }

    @FXML
    private void deconnexion(ActionEvent event) {
    }
    
}
