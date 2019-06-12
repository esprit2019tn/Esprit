/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class ValidationUserController implements Initializable {

    private ObservableList<User> personData = FXCollections.observableArrayList();

    @FXML
    private Label userName;
    
    @FXML
    private TableView<User> personTable;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private Label prenomLabel;

    @FXML
    private Label nomLabel;

    @FXML
    private Label adresseLabel;

    @FXML
    private Label dateNaissLabel;

    @FXML
    private Label sexeLabel;

    @FXML
    private Label emailLabel;
   
    
    private Label label;
        
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
    
    
    public void getPersonData() {
                    UserDao userDao=new UserDao();

        for (User user : userDao.findUserToValid()) 
        { 
           personData.add(user);
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
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        getPersonData();
        personTable.getItems().clear();
        personTable.setItems(personData);
        

        
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue)); 
    }
    
    
    
    
        private void showPersonDetails(User user) {
        if (user != null) {
            // Fill the labels with info from the person object.
            nomLabel.setText(user.getNom());
            prenomLabel.setText(user.getPrenom());
            dateNaissLabel.setText(user.getDateNaiss().toString());
            adresseLabel.setText(user.getAdresse());
            sexeLabel.setText(user.getAdresse());
            emailLabel.setText(user.getEmail());
        } else {
            // Person is null, remove all the text.
            nomLabel.setText("");
            prenomLabel.setText("");
            dateNaissLabel.setText("");
            adresseLabel.setText("");
            sexeLabel.setText("");
            emailLabel.setText("");
        }
    }

        
@FXML
void validUser(ActionEvent event) throws IOException {
    UserDao userDao=new UserDao();
    userDao.setValidationUser(emailLabel.getText());
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationUser.fxml"));
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
    
    
    
    void btnGrEvent(ActionEvent event) throws IOException {
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationEvent.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }

    void btnGrPubli(ActionEvent event) {

    }

    void btnGrRec(ActionEvent event) {

    }

    void btnGrUser(ActionEvent event) throws IOException {
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationUser.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }

    void btnHome(ActionEvent event) throws IOException {
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
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
