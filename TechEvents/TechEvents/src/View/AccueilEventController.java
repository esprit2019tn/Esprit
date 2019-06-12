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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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


    
    private JFXComboBox<Event> comboEvent;

    ObservableList<Event> lstevent = FXCollections.observableArrayList();

    EventDao eda = new EventDao();
    @FXML
    private TableView<Event> eventTable;
    @FXML
    private TableColumn<Event, ImageView> photoColumn;
    @FXML
    private TableColumn<Event, String> titreColumn;
    @FXML
    private TableColumn<Event, String> DateColumn;
    @FXML
    private TableColumn<Event, Integer> DureeColumn;
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

        for (Event event : eventDao.findAll()) 
        { 
           eventData.add(event);
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eda.updateImage();
        eventData.addAll(eda.findAll());
        User user=UserSession.getUserSession();
        if(user!=null && !user.getNom().equals(""))
        {   
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            userPane.setVisible(true);
            userName.setVisible(true);
            userName.setText("Bienvenue "+user.getNom()+" "+user.getPrenom());
            
        }
        
        
            if(UserSession.verifUserSession())
                userName.setText(UserSession.getUserSession().getNom()+" "+UserSession.getUserSession().getPrenom());
                setTable();
 
       // lstevent.addAll(eda.findAll());
       // comboEvent.setItems(lstevent);
        titreColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        DureeColumn.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        photoColumn.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        
        titreColumn.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        DureeColumn.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        DateColumn.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        photoColumn.setStyle(" -fx-alignment: center ;");
        
        eventTable.setItems(eventData);
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
  public  void splitMenu(ActionEvent event) {
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

    private void showEvent(ActionEvent event) throws BackingStoreException, IOException {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("CreteEVT.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
    }

    
    private void showReclamation(ActionEvent event) throws Exception{
                 Parent home_page_parent = FXMLLoader.load(getClass().getResource("BlockEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
    }

    public ObservableList<Event> getEventData() {
        return eventData;
    }

    public void setEventData(ObservableList<Event> eventData) {
        this.eventData = eventData;
    }

    public Pane getUserPane() {
        return userPane;
    }

    public void setUserPane(Pane userPane) {
        this.userPane = userPane;
    }

    public Label getUserName() {
        return userName;
    }

    public void setUserName(Label userName) {
        this.userName = userName;
    }

    public JFXButton getBtnInscription() {
        return btnInscription;
    }

    public void setBtnInscription(JFXButton btnInscription) {
        this.btnInscription = btnInscription;
    }

    public JFXButton getBtnConnexion() {
        return btnConnexion;
    }

    public void setBtnConnexion(JFXButton btnConnexion) {
        this.btnConnexion = btnConnexion;
    }

    public JFXButton getBtnDeconnexion() {
        return btnDeconnexion;
    }

    public void setBtnDeconnexion(JFXButton btnDeconnexion) {
        this.btnDeconnexion = btnDeconnexion;
    }



    public JFXComboBox<Event> getComboEvent() {
        return comboEvent;
    }

    public void setComboEvent(JFXComboBox<Event> comboEvent) {
        this.comboEvent = comboEvent;
    }

    public ObservableList<Event> getLstevent() {
        return lstevent;
    }

    public void setLstevent(ObservableList<Event> lstevent) {
        this.lstevent = lstevent;
    }

    public EventDao getEda() {
        return eda;
    }

    public void setEda(EventDao eda) {
        this.eda = eda;
    }

    public TableView<Event> getEventTable() {
        return eventTable;
    }

    public void setEventTable(TableView<Event> eventTable) {
        this.eventTable = eventTable;
    }

    public TableColumn<Event, ImageView> getPhotoColumn() {
        return photoColumn;
    }

    public void setPhotoColumn(TableColumn<Event, ImageView> photoColumn) {
        this.photoColumn = photoColumn;
    }

    public TableColumn<Event, String> getTitreColumn() {
        return titreColumn;
    }

    public void setTitreColumn(TableColumn<Event, String> titreColumn) {
        this.titreColumn = titreColumn;
    }

    public TableColumn<Event, String> getDateColumn() {
        return DateColumn;
    }

    public void setDateColumn(TableColumn<Event, String> DateColumn) {
        this.DateColumn = DateColumn;
    }

    public TableColumn<Event, Integer> getDureeColumn() {
        return DureeColumn;
    }

    public void setDureeColumn(TableColumn<Event, Integer> DureeColumn) {
        this.DureeColumn = DureeColumn;
    }
    
    
}