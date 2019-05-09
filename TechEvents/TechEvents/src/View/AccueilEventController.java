/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Event;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class AccueilEventController implements Initializable {
    
    @FXML
    private JFXButton btnInscription;

    @FXML
    private JFXButton btnDeconnexion;
    
    @FXML
    private JFXButton btnConnexion;
    
    @FXML
    private Label userName;
    
    @FXML
    private ListView<?> listView;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    void begin(ActionEvent event) throws IOException {
        ObservableList<Event> data = FXCollections.observableArrayList();
        data.addAll(new Event("abc", "adksgqds"), new Event("Horse", "456"), new Event("Jam", "789"));

        final ListView<Event> listView = new ListView<Event>(data);
        listView.setCellFactory(new Callback<ListView<Event>, ListCell<Event>>() {
            @Override
            public ListCell<Event> call(ListView<Event> listView) {
                return new CustomListCell();
            }
        });
        }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        User user=UserSession.getUserSession();
        if(!user.getNom().equals(""))
        {
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            userName.setVisible(true);
            userName.setText("Bienvenue "+user.getNom()+" "+user.getPrenom());
            
        }
        

    
 
    }
    @FXML
    void connexion(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
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

     private class CustomListCell extends ListCell<Event> {
        private Text name;
        private Text desc;

        public CustomListCell() {
            super();
            name = new Text();
            desc = new Text();
            VBox vBox = new VBox(name, desc);

        }   
     }

     
    @FXML
    void deconnexion(ActionEvent event) throws BackingStoreException, IOException {
        UserSession.destroyUserSession();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        

    }

     
     
}
