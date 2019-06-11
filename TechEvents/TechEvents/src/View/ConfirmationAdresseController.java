/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class ConfirmationAdresseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField codeConfirmation;

    @FXML
    private JFXTextField email;

    @FXML
    private Label msgErreur;
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
    private Pane menuPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    public void setEmail(String email) {
        this.email.setText(email);
    }
    
    
    
    
    @FXML
    void confirmer(ActionEvent event) throws IOException {
        
        UserDao userDao=new UserDao();
        String confCode=userDao.getConfirmationCode(email.getText());
        if(confCode!=null){
            if(confCode.equals(codeConfirmation.getText())){
                userDao.setConfirmationEmail(email.getText());
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();         
            }
            else{
                msgErreur.setText("Code de confirmation incorrecte");
                msgErreur.setTextFill(Color.RED);
            }
        }
        else{
                msgErreur.setText("Email incorrecte");
                msgErreur.setTextFill(Color.RED);
        }

        
            
        
        
        

    }

    @FXML
    private void splitMenu(ActionEvent event) {
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
    
   
    
    
    
}
