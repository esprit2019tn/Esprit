/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dhiae
 */
public class ReclamationController implements Initializable {


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
    @FXML
    private JFXButton btnValider;
    @FXML
    private JFXButton btnAnnuler;

    @FXML
    void connexion(ActionEvent event) {

    }

    @FXML
    void deconnexion(ActionEvent event) {

    }

    @FXML
    void inscription(ActionEvent event) {

    }

    @FXML
    void splitMenu(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        User user=UserSession.getUserSession();
        if(!user.getNom().equals(""))
        {   
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            userPane.setVisible(true);
            userName.setVisible(true);
            userName.setText("Bienvenue "+user.getNom()+" "+user.getPrenom());
            
        }  
    
    }

    @FXML
    private void insertReclam(ActionEvent event) {
        
    }

    @FXML
    private void init(ActionEvent event) {
    }
}