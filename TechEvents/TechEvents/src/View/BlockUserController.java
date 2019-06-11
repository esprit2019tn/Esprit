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
public class BlockUserController implements Initializable {

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
    private Label Sujet;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label SujetLabel;
    @FXML
    private Label Explication;
    @FXML
    private Label ExplicationLabel;
    @FXML
    private Pane menuPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void splitMenu(ActionEvent event) {
        if(menuPane.isVisible())
            menuPane.setVisible(false);
        else
            menuPane.setVisible(true); 
    }

    @FXML
    private void validUser(ActionEvent event) {
    }

    
}
