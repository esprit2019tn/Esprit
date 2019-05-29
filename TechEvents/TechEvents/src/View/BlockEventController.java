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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Reclamation> personTable;
    @FXML
    private TableColumn<Reclamation, String> lastNameColumn;
    @FXML
    private TableColumn<Reclamation, String> firstNameColumn;
    @FXML
    private TableColumn<Reclamation, String> emailColumn;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label sujetLabel;
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
                setTable();
        } catch (BackingStoreException ex) {
            Logger.getLogger(ValidationUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
    }    

    public void setTable(){
               // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("firstNameColumn"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("lastNameColumn"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("emailNameColumn"));

        getPersonData();
        personTable.getItems().clear();
        personTable.setItems(ReclamationData);
        
        
        
        
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
