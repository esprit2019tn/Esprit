/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author dhiae
 */
public class BlockEventController implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private TableView<?> personTable;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
