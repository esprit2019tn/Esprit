/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.RoleUser;
import Entity.User;
import Metier.EmailSend;
import Metier.UserSession;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class InscriptionController implements Initializable {

    
    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    
    @FXML
    private JFXDatePicker dateNaiss;

    @FXML
    private JFXTextField adresse;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password1;

    @FXML
    private JFXRadioButton homme;

    @FXML
    private JFXRadioButton femme;
    
    @FXML
    private Label erreur;

    private Pane menu;
        
    ToggleGroup groupSexe=new ToggleGroup();
    @FXML
    private Pane menuPane;
   /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homme.setToggleGroup(groupSexe);
        femme.setToggleGroup(groupSexe);
    }    
    
    
    @FXML
    void splitMenu(ActionEvent event) {
              if(menuPane.isVisible())
            menuPane.setVisible(false);
        else
            menuPane.setVisible(true); 
    }

    
        @FXML
    void onClick(ActionEvent event) throws IOException {
        
        if(password.getText().equals(password1.getText())){
        
        String sexe=null;
        if(homme.isSelected())
            sexe="Homme";
        else if(femme.isSelected())
            sexe="Femme";
        
        
        Random rand = new Random();
        int randomNum = rand.nextInt((999999 - 100000) + 1) + 100000;
        String confirmationCode=String.valueOf(randomNum);
        User user=new User(nom.getText(),prenom.getText(),java.sql.Date.valueOf(dateNaiss.getValue()),sexe,adresse.getText(),email.getText(),password.getText(),RoleUser.SimpleUser,confirmationCode);        
        UserDao userDao=new UserDao();
        userDao.insert(user);
            EmailSend.sendConfirmation(email.getText(),confirmationCode);
        System.out.println(nom.getText()+" "+prenom.getText()+" "+adresse.getText()+" "+email.getText()+" "+password.getText()+"");
        //////////////////
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ConfirmationAdresse.fxml"));
        Parent home_page_parent = (Parent) loader.load();

         ConfirmationAdresseController confAdrController=loader.getController();
            confAdrController.setEmail(email.getText());
        ///////////////
        //Parent home_page_parent = FXMLLoader.load(getClass().getResource("ConfirmationAdresse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        }
        else{
            erreur.setText("Les mots de passe ne correspondent pas");
        }
               
        
    }
    
    
    void btnMenuHome(ActionEvent event) throws BackingStoreException, IOException {
        UserSession.destroyUserSession();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        

    }
    
    

    
    
}
