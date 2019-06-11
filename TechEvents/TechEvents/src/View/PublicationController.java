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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

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

    @FXML
    private void listPublication(ActionEvent event) throws IOException {
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("ListePublication.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
    }

}
