/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ActualiteDao;
import Dao.EventDao;
import Entity.Actualite;
import Entity.Event;
import Metier.UserSession;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PublicationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField desc;

    @FXML
    private JFXComboBox<Event> comboEvent;

    ObservableList<Event> lstEvent = FXCollections.observableArrayList();

    EventDao eda = new EventDao();

    ActualiteDao ado = new ActualiteDao();
    @FXML
    private JFXButton publierbtn;

    @FXML
    public void publier(ActionEvent event) {
        System.out.println("View.PublicationController.publier()");
        ado.insert(new Actualite(desc.getText().toString(), comboEvent.getSelectionModel().getSelectedItem().getIdEvent()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publication");
            alert.setHeaderText("Publication crée avec succées");
            alert.setContentText("La publication à été crée ");
            alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession.getUserSession();
        ActualiteDao actualiteDao = new ActualiteDao();
        actualiteDao.findAll();

        lstEvent.addAll(eda.findAll());
        comboEvent.setItems(lstEvent);

    }

    @FXML
    private void splitMenu(ActionEvent event) {
    }

}
