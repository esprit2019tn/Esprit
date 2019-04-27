/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class InscriptionController implements Initializable {

    
        @FXML
    private PasswordField password;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField email;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    
        @FXML
    void onClick(ActionEvent event) {
            User user=new User(nom.getText(),prenom.getText(),adresse.getText(),email.getText(),password.getText());
        UserDao userDao=new UserDao();
        userDao.insert(user);
        System.out.println(nom.getText()+" "+prenom.getText()+" "+adresse.getText()+" "+email.getText()+" "+password.getText()+"");
   

    }
    
}
