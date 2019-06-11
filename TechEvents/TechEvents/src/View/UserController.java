/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class UserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       @FXML
    private Pane userPane;

    @FXML
    private Label userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField adresse;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password1;

    @FXML
    private JFXDatePicker dateNaiss;

    @FXML
    private JFXRadioButton homme;

    @FXML
    private JFXRadioButton femme;

    @FXML
    private Label erreur;

    @FXML
    private JFXButton btnInscription;

    @FXML
    private JFXButton btnConnexion;


    @FXML
    private JFXButton btnDeconnexion;
    @FXML
    private Pane menuPane;




    
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
        
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        Date date = user.getDateNaiss();		
	//ZoneId defaultZoneId = ZoneId.systemDefault();		
	//Instant instant = date.toInstant();		
	//LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        //dateNaiss.setValue(localDate);
        
        if(user.getSexe().equals("Homme"))
            homme.setSelected(true);
        else if(user.getSexe().equals("Femme"))
            femme.setSelected(true); 
        email.setText(user.getEmail());
        adresse.setText(user.getAdresse());
    }   
    @FXML
    void splitMenu(ActionEvent event) {
        if(menuPane.isVisible())
            menuPane.setVisible(false);
        else
            menuPane.setVisible(true); 
    }
     
   @FXML
  public  void connexion(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
    }

    @FXML
 public   void inscription(ActionEvent event) throws IOException {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    } 
    @FXML
  public  void deconnexion(ActionEvent event) throws BackingStoreException, IOException {
        UserSession.destroyUserSession();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        

    }
    
    @FXML
    void modifier(ActionEvent event) {

    }
    
}
