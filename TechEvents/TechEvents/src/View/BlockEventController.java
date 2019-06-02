/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import Entity.User;
import Dao.EventDao;
import Dao.ReclamationDao;
import Entity.Actualite;
import Entity.Event;
import Entity.Reclamation;
import Metier.UserSession;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author dhiae
 */
public class BlockEventController implements Initializable {
 private ObservableList<Reclamation> ReclamationData = FXCollections.observableArrayList();
 
    @FXML
    private Label userName;
   
    @FXML
    private TableView<Reclamation> reclamationTable;
    
    //private TableColumn<Reclamation, String> lastNameColumn;
   // private TableColumn<Reclamation, String> firstNameColumn;
    //private TableColumn<Reclamation, String> emailColumn;
    
    @FXML
     private TableColumn<Reclamation, User> nomUtilisateur;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, Event> Evenement;
    @FXML
    private Label explicationLabel;
    @FXML
    private Pane menu;
    
    ReclamationDao recDao = new ReclamationDao();
    /**
     * Initializes the controller class.
     */
    
     public void getPersonData() {
        ReclamationDao reclamationDao=new ReclamationDao();

        //for (Reclamation Reclam : ReclamationDao.findAll())
        for (Reclamation reclam : recDao.findAll())
        { 
           ReclamationData.add(reclam);
        } 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            if(UserSession.verifUserSession())
                userName.setText(UserSession.getUserSession().getNom()+" "+UserSession.getUserSession().getPrenom());
               // setTable();
        } catch (BackingStoreException ex) {
            Logger.getLogger(ValidationUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ReclamationDao recDao = new ReclamationDao();
        
         ReclamationData.addAll(recDao.findAll());
        nomUtilisateur.setCellValueFactory(new PropertyValueFactory<Reclamation, User>("user"));
        sujet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("sujetReclam"));
        Evenement.setCellValueFactory(new PropertyValueFactory<Reclamation, Event>("event"));

        reclamationTable.setItems(ReclamationData);
        // TODO
                reclamationTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(".handle()" + reclamationTable.getSelectionModel().getSelectedItem().getTextReclam());
           Reclamation r = reclamationTable.getSelectionModel().getSelectedItem();
                explicationLabel.setText(r.getTextReclam());

            }

        });
    }    

    public void setTable(){
               // Initialize the person table with the two columns.
        nomUtilisateur.setCellValueFactory(new PropertyValueFactory<Reclamation, User>("user"));
        sujet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("sujetReclam"));
        Evenement.setCellValueFactory(new PropertyValueFactory<Reclamation, Event>("event"));

        getPersonData();
        reclamationTable.getItems().clear();
        reclamationTable.setItems(ReclamationData);
        
        
       
        

    }

     
    
    @FXML
    private void splitMenu(ActionEvent event) {
    }

    @FXML
    private void blockEvent(ActionEvent event) {
    }

    @FXML
    private void btnHome(ActionEvent event) {
    }

    @FXML
    private void btnGrUser(ActionEvent event) {
    }

    @FXML
    private void btnGrEvent(ActionEvent event) {
    }

    @FXML
    private void btnGrPubli(ActionEvent event) {
    }

    @FXML
    private void btnGrRec(ActionEvent event) {
    }

   
        
        
}
