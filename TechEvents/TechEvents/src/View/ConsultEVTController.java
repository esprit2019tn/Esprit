/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
import Dao.SponsorDao;
import Entity.Sponsor;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxListCell;
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
    @FXML
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        titre.setText(CreteEVTController.getevt().getTitre());
        date.setText(CreteEVTController.getevt().getDateEvent());
        cptmax.setText(CreteEVTController.getevt().getCapaciteMax().toString());
        cptmin.setText(CreteEVTController.getevt().getCapaciteMin().toString());
        desc.setText(CreteEVTController.getevt().getDesc());
        duree.setText(CreteEVTController.getevt().getDuree().toString());
        User user = UserSession.getUserSession();
        try {
            if (UserSession.verifUserSession()) {
                username.setText(UserSession.getUserSession().getNom() + " " + UserSession.getUserSession().getPrenom());
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
    
    public void getlstsponsor(){
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
    }

}
