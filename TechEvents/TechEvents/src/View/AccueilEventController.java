/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
import Entity.Event;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class AccueilEventController implements Initializable {
    
     private ObservableList<Event> eventData = FXCollections.observableArrayList();

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
    private TableView<?> eventTable;

    @FXML
    private TableColumn<?, ?> titreColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private Pane menu;
    
    ////////////////////////////////





    


    /**
     * Initializes the controller class.
     */
   /**
     * Initializes the controller class.
     */
    
    
    public void getPersonData() {
        EventDao eventDao=new EventDao();

        for (Event event : eventDao.findAll()) 
        { 
           eventData.add(event);
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        User user=UserSession.getUserSession();
        if(user!=null)
        {   
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            userPane.setVisible(true);
            userName.setVisible(true);
            userName.setText("Bienvenue "+user.getNom()+" "+user.getPrenom());
            
        }
        
        
        try {
            if(UserSession.verifUserSession())
                userName.setText(UserSession.getUserSession().getNom()+" "+UserSession.getUserSession().getPrenom());
                setTable();
        } catch (BackingStoreException ex) {
            Logger.getLogger(ValidationUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
    public void setTable(){
     /*          // Initialize the person table with the two columns.
        titreColumn.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());

        getPersonData();
        eventTable.getItems().clear();
        eventTable.setItems(eventData);
        */


    }
    
    
    
    


        
@FXML
void validUser(ActionEvent event) throws IOException {
   /* UserDao userDao=new UserDao();
    userDao.setValidationUser(emailLabel.getText());
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationUser.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  */
    }




    @FXML
    void splitMenu(ActionEvent event) {
        if(menu.isVisible())
            menu.setVisible(false);
        else
            menu.setVisible(true);
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
    
    public void showEvent(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("CreteEVT.fxml"));

    }
    
    @FXML
    public void userPage(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("User.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    } 

             //   app_stage.show();
    
    
}