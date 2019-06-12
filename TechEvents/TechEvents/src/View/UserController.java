/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;

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
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField adresse;

    @FXML
    private JFXTextField email;


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
    @FXML
    private JFXPasswordField ancienMotDePasse;
    @FXML
    private JFXPasswordField nouveauMotDePasse;

    User user;
    ToggleGroup groupSexe=new ToggleGroup();



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homme.setToggleGroup(groupSexe);
        femme.setToggleGroup(groupSexe);
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
        
            if(UserSession.verifUserSession()){
                this.user=UserSession.getUserSession();
                nom.setText(user.getNom());
                prenom.setText(user.getPrenom());
                dateNaiss.setValue(Instant.ofEpochMilli(user.getDateNaiss().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
        if(user.getSexe().equals("Homme"))
                    homme.setSelected(true);
                else if(user.getSexe().equals("Femme"))
                    femme.setSelected(true);
                email.setText(user.getEmail());           
                adresse.setText(user.getAdresse());
            }

        ancienMotDePasse.setText(null);
        nouveauMotDePasse.setText(null);
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
        User u=UserSession.getUserSession();
        if(ancienMotDePasse.getText()==null || ancienMotDePasse.getText()=="" || u.getPassword().equals(ancienMotDePasse.getText())){
        String sexe=null;
        if(homme.isSelected())
            sexe="Homme";
        else if(femme.isSelected())
            sexe="Femme";       
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        if(dateNaiss.getValue()!=null)
            user.setDateNaiss(Date.from(dateNaiss.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));   
        user.setSexe(sexe);
        user.setAdresse(adresse.getText());
        user.setEmail(email.getText());
        user.setPassword(nouveauMotDePasse.getText());
            UserDao userDao=new UserDao();
            try {
            userDao.update(user);
            } catch (Exception e) {
               erreur.setTextFill(Color.web("#FF0000"));
               erreur.setText("Impossible de mettre a jour");
            }
            UserSession.createUserSession(user);
        erreur.setTextFill(Color.web("#008000"));
        erreur.setText("Mise à jour effectuée avec succès");
        nouveauMotDePasse.setText(null);
        ancienMotDePasse.setText(null);
        }
        else{
               erreur.setTextFill(Color.web("#FF0000"));
               erreur.setText("Ancien mot de passe incorrect");        }
        

    }
    
}
