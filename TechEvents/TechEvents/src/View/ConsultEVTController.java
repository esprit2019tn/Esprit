/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
import Dao.SponsorDao;
import Entity.Event;
import Entity.Sponsor;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ConsultEVTController implements Initializable {

    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField cptmax;
    @FXML
    private JFXTextField cptmin;
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXTextField duree;
    @FXML
    private JFXTextField etat;
    @FXML
    private JFXButton reserver;
    private Label username;
    @FXML
    private JFXListView<Sponsor> sponsorlst;

    public ObservableList<Sponsor> lstspr = FXCollections.observableArrayList();

    SponsorDao sdo = new SponsorDao();

    ArrayList<Sponsor> lstsponsor = new ArrayList<>();
    @FXML
    private JFXButton updatebtn;
    @FXML
    private JFXListView<Sponsor> LstSprEvent;
    @FXML
    private JFXButton reclambtn;
    @FXML
    private JFXButton btnAnnulerEvt;
    @FXML
    private JFXDatePicker picker;
    @FXML
    private Label nbrres;
    @FXML
    private JFXButton btntermine;
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
    private Pane menuPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        User user = UserSession.getUserSession();
//        if (user.getRole().equals(user.getRole().SimpleUser)) {
//            reclambtn.setDisable(true);
//            btntermine.setDisable(true);
//            btnAnnulerEvt.setDisable(true);
//            updatebtn.setDisable(true);
//            btntermine.setDisable(true);
//        }
        if(user!=null && !user.getNom().equals(""))
        {   
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            userPane.setVisible(true);
            userName.setVisible(true);
            userName.setText("Bienvenue "+user.getNom()+" "+user.getPrenom());
            
        }

        EventDao eda = new EventDao();

        titre.setText(CreteEVTController.getevt().getTitre());
        //  date.setText(CreteEVTController.getevt().getDateEvent());
        cptmax.setText(CreteEVTController.getevt().getCapaciteMax().toString());
        cptmin.setText(CreteEVTController.getevt().getCapaciteMin().toString());
        desc.setText(CreteEVTController.getevt().getDesc());
        duree.setText(CreteEVTController.getevt().getDuree().toString());
        etat.setText(CreteEVTController.getevt().getStatut());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        picker.setValue(LocalDate.parse(CreteEVTController.getevt().getDateEvent(), formatter));
        nbrres.setText(String.valueOf(eda.getnbrres(CreteEVTController.getevt())));
        nbrres.setStyle("-fx-text-fill: red;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; ");

        switch (etat.getText()) {
            case "Annulé":
                etat.setStyle("-fx-text-fill: red;");
                break;
            case "Terminé":
                etat.setStyle("-fx-text-fill: bleu;");
                break;
            case "Disponible":
                etat.setStyle("-fx-text-fill: green;");
                break;
            case "Reporté":
                etat.setStyle("-fx-text-fill: yellow; ");
                break;
        }
        try {
            if (UserSession.verifUserSession()) {
//                username.setText(UserSession.getUserSession().getNom() + " " + UserSession.getUserSession().getPrenom());
            }
        } catch (BackingStoreException ex) {
            Logger.getLogger(CreteEVTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sdo.eventHasSponsor(CreteEVTController.getevt())) {
            LstSprEvent.setVisible(false);
            addSponsor();
        } else {
            sponsorlst.setVisible(false);
            getlstsponsor();
        }

    }

    public void addSponsor() {
        lstspr.addAll(sdo.findAll());
        sponsorlst.setCellFactory(CheckBoxListCell.forListView(new Callback<Sponsor, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Sponsor param) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected)
                        -> {
                    System.out.println("Check box for " + param + " changed from " + wasSelected + " to " + isNowSelected + " zzz " + obs);
                    if (isNowSelected) {
                        lstsponsor.add(param);
                        System.out.println("add" + param);
                    } else {
                        System.out.println("remove" + param);
                        lstsponsor.remove(param);
                    }
                }
                );
                return observable;
            }

        }));
        sponsorlst.setItems(lstspr);
    }

    public void getlstsponsor() {
        lstspr.addAll(sdo.findByEvent(CreteEVTController.getevt()));
        LstSprEvent.setItems(lstspr);
    }

    @FXML
    private void reserver() {
        EventDao eda = new EventDao();
        if (eda.existe(CreteEVTController.getevt(), UserSession.getUserSession()) != false) {
            eda.updateUserEvt(CreteEVTController.getevt(), UserSession.getUserSession());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation evenement");
            alert.setHeaderText("Evenement a été réservé");
            alert.setContentText("L'événement " + titre.getText() + " à été réservé à " + UserSession.getUserSession().getNom());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Reservation evenement");
            alert.setHeaderText("Vous avez déja réservé cet événement");
            alert.setContentText("L'événement " + titre.getText() + "n'à pas été réservé à " + UserSession.getUserSession().getId());
            alert.showAndWait();
        }
    }

    @FXML
    private void addsponsor(ActionEvent event) {
        sdo.updateSponsorEvt(CreteEVTController.getevt(), lstsponsor);
        for (Sponsor l : lstsponsor) {
            System.out.println("-------------ID---------------" + l.getIdSponsor());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(CreteEVTController.getevt().getDateEvent(), formatter);
        System.out.println("update" + picker.getValue().compareTo(ld));
        EventDao eda = new EventDao();
        Event evt = new Event();
        System.out.println("View.ConsultEVTController.addsponsor()" + titre.getText());
        evt.setIdEvent(CreteEVTController.getevt().getIdEvent());
        evt.setTitre(titre.getText());
        evt.setDuree(Long.parseLong(duree.getText()));
        evt.setCapaciteMax(Long.parseLong(cptmax.getText()));
        evt.setCapaciteMin(Long.parseLong(cptmin.getText()));
        evt.setStatut(etat.getText());
        evt.setDesc(desc.getText());
        evt.setDateEvent(picker.getValue().toString());
        if (picker.getValue().compareTo(ld) > 0) {
            evt.setStatut("Reporté");
            evt.setDateEvent(picker.getValue().toString());
        }
        eda.update(evt);

    }

    @FXML
    private void reclamer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent home_page_parent = (Parent) loader.load();

        ReclamationController reclamationController = loader.getController();
        //       Reclamation reclamation=new Reclamation();
        //       reclamation.setEvent(CreteEVTController.getevt());
        reclamationController.setIdEvent(CreteEVTController.getevt().getIdEvent());

        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void AnnulerEvt(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Annuler l'événement");
        alert.setHeaderText("Annuler l'événement");
        alert.setResizable(false);
        alert.setContentText("Vous étes sûr d'annuler l'événement");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EventDao eda = new EventDao();
            Event evt = CreteEVTController.getevt();
            evt.setStatut("Annulé");
            eda.update(evt);

        }

        //oke button is pressed
    }

    @FXML
    private void ternimerEvt(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Evénement Terminé");
        alert.setHeaderText("Terminer l'événement");
        alert.setResizable(false);
        alert.setContentText("Vous étes sûr de terminer l'événement");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EventDao eda = new EventDao();
            Event evt = CreteEVTController.getevt();
            evt.setStatut("Terminé");
            eda.update(evt);

        }

        //oke button is pressed
    }

    @FXML
    private void splitMenu(ActionEvent event) {
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
