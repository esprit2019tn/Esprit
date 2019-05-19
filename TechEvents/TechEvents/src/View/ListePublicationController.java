/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ActualiteDao;
import Entity.Actualite;
import Entity.Event;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ListePublicationController implements Initializable {

    @FXML
    private TableView<Actualite> eventTable;
    @FXML
    private TableColumn<Actualite, String> titreColumn;
    @FXML
    private TableColumn<Actualite, String> descriptionColumn;
    @FXML
    private TableColumn<Actualite, Date> datecolumn;

    public ObservableList<Actualite> list = FXCollections.observableArrayList();

    ActualiteDao ado = new ActualiteDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        titreColumn.setCellValueFactory(new PropertyValueFactory<Actualite, String>("titre"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Actualite, String>("descActu"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<Actualite, Date>("dateActu"));

        list.addAll(ado.findAll());
        eventTable.setItems(list);
        
    }

    @FXML
    private void splitMenu(ActionEvent event) {
    }

}
