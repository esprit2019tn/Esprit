/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Entity.User;
import Dao.EventDao;
import Dao.ReclamationDao;
import Entity.Event;
import Entity.Reclamation;
import Metier.EmailSend;
import Metier.UserSession;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private TableColumn<Reclamation, String> Date;
    @FXML
    private Label explicationLabel;
    private Pane menu;
    
     // @FXML
    //private Button Deconnecter;
    
    ReclamationDao recDao = new ReclamationDao();
    @FXML
    private Pane menuPane;
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
        Date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));

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

    

     
    
    @FXML
    private void splitMenu(ActionEvent event) {if(menu.isVisible())
        if(menuPane.isVisible())
            menuPane.setVisible(false);
        else
            menuPane.setVisible(true); 
    }

    @FXML
    private void blockEvent(ActionEvent event) {
        EventDao eventDao=new EventDao();
         Reclamation reclamation=reclamationTable.getSelectionModel().getSelectedItem();
         eventDao.blockEvent(reclamation.getEvent().getIdEvent());
        
        EmailSend.sendRepReclamation(reclamation.getUser().getEmail(), reclamation.getEvent());
        
        
    }

    private void btnHome(ActionEvent event) throws IOException {
        
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        
    }

    private void btnGrUser(ActionEvent event) throws IOException {
        
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationUser.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        
    }

    private void btnGrEvent(ActionEvent event) throws IOException {
        
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("CreteEVT.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        
        
    }

    private void btnGrPubli(ActionEvent event) throws IOException {
        
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("ListePublication.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
        
    }

    private void btnGrRec(ActionEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("BlockEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
    }

 //@FXML
   // void deconnect(ActionEvent event) throws BackingStoreException, IOException {
        // UserSession.destroyUserSession();
       // Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
      //  Scene home_page_scene = new Scene(home_page_parent);
       // Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           //     app_stage.hide();
            //    app_stage.setScene(home_page_scene);
             //   app_stage.show(); 
        //
        
  //  }
        
        
}
