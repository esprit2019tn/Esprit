/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.RoleUser;
import Entity.User;
import Metier.UserSession;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label oublier;

    @FXML
    private Label Errors;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void connexion(ActionEvent event) throws IOException {     
              UserDao userDao=new UserDao();
        User user=userDao.findUser(email.getText(), password.getText());
        if(user==null){
             Errors.setText("Email ou mot de passe incorrect");
        }
        else{
            if(!user.getConfirmation()){
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ConfirmationAdresse.fxml"));
                Parent home_page_parent = (Parent) loader.load();
                 ConfirmationAdresseController confAdrController=loader.getController();
                 confAdrController.setEmail(email.getText());
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.hide();
                        app_stage.setScene(home_page_scene);
                        app_stage.show(); 
            }
            else if(!user.getActive()){
                Errors.setText("Votre inscription est en cours de validation");
            }
            else{
                UserSession.createUserSession(user);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AccueilEvent.fxml"));
                Parent home_page_parent = (Parent) loader.load();
                 AccueilEventController confAdrController=loader.getController();
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.hide();
                        app_stage.setScene(home_page_scene);
                        app_stage.show(); 
                
            }
            

        }
    }

    @FXML
    void inscription(ActionEvent event) throws IOException {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
    
    

    
        @FXML
    void recupererPassword(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RecupererPassword.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }


    

    
}
