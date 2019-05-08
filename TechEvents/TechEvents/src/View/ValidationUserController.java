/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class ValidationUserController implements Initializable {

    private ObservableList<User> personData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> personTable;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;

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
    
    @FXML
    private JFXListView<Label> listview;
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
        setTable();
        
    }   
    
    public void setTable(){
               // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
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
void validUser(ActionEvent event) {
    UserDao userDao=new UserDao();
    userDao.setValidationUser(emailLabel.getText());
    setTable();
    }

    
}
