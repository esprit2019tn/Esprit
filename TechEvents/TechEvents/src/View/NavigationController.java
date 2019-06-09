/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.RoleUser;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class NavigationController implements Initializable {

    @FXML
    private GridPane menu;
    @FXML
    private VBox menup;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int i=0;
       try {
        JFXButton button_g_reclamation = new JFXButton("Gérer réclamation");
        
        //button validation
        JFXButton button_validation = new JFXButton("Valider utilisateur");
        button_validation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent home_page_parent;
                try {
                home_page_parent = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
                } catch (IOException ex) {
                    Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //**********************************************************************
        
        //button Gérer événement        
        JFXButton button_g_event = new JFXButton("Gérer événement");
        button_g_event.setMaxSize(1000, 20);
        button_g_event.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent home_page_parent;
                try {
                home_page_parent = FXMLLoader.load(getClass().getResource("CreteEVT.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
                } catch (IOException ex) {
                    Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        menu.addRow(i++, button_g_event);
        menu.addRow(i++, button_g_reclamation);
        
            if((UserSession.verifUserSession()) && (UserSession.getUserSession().getRole().equals(RoleUser.Admin)))
                menu.addRow(i++, button_validation);
            
            
            
            
        } catch (BackingStoreException ex) {
            Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }    


    
}
