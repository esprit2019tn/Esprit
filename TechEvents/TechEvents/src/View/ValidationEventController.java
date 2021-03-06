/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
import Entity.Event;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class ValidationEventController implements Initializable {
    
        private ObservableList<Event> eventData = FXCollections.observableArrayList();

    @FXML
    private Label userName;
    



    @FXML
    private TableView<Event> eventTable;

    @FXML
    private TableColumn<Event,String> titreColumn;

    @FXML
    private TableColumn<Event,String>  descriptionColumn;

    @FXML
    private Label titreLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label dateEventLabel;

    @FXML
    private Label capaciteMaxLabel;

    @FXML
    private Label capaciteMinLabel;

    @FXML
    private Label dureeLabel;

    
    int idEvent;
    @FXML
    private Pane userPane;
    @FXML
    private JFXButton btnInscription;
    @FXML
    private JFXButton btnConnexion;
    @FXML
    private JFXButton btnDeconnexion;
    @FXML
    private Pane menuPane;


    /**
     * Initializes the controller class.
     */
   /**
     * Initializes the controller class.
     */
    
    
    public void getPersonData() {
        EventDao eventDao=new EventDao();

        for (Event event : eventDao.findEventNonActive()) 
        { 
           eventData.add(event);
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            if(UserSession.verifUserSession())
                userName.setText(UserSession.getUserSession().getNom()+" "+UserSession.getUserSession().getPrenom());
                setTable();

        
    }   
    
    public void setTable(){
               // Initialize the person table with the two columns.
        titreColumn.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());

        getPersonData();
        eventTable.getItems().clear();
        eventTable.setItems(eventData);
        

        
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        eventTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue)); 
    }
    
    
    
    
        private void showPersonDetails(Event event) {
        if (event != null) {
            // Fill the labels with info from the person object.
            idEvent=event.getIdEvent();
            titreLabel.setText(event.getTitre());
            descriptionLabel.setText(event.getDesc());
            capaciteMaxLabel.setText(event.getCapaciteMax().toString());
            capaciteMinLabel.setText(event.getCapaciteMin().toString());
            dateEventLabel.setText(event.getDateEvent().toString());
            dureeLabel.setText(event.getDuree().toString());
        } else {
            // Person is null, remove all the text.
            titreLabel.setText("");
            descriptionLabel.setText("");
            capaciteMaxLabel.setText("");
            capaciteMinLabel.setText("");
            dateEventLabel.setText("");
            dureeLabel.setText("");
        }
    }

        
@FXML
void validUser(ActionEvent event) throws IOException {
    EventDao eventDao=new EventDao();
    eventDao.setValidationEvent(idEvent);
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationEvent.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
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

    
}
