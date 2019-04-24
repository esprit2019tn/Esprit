/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author AYMEN
 */
public class InscriptionPane extends AnchorPane implements Initializable{
    
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
    
   
    
    public InscriptionPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InscriptionPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @FXML
    private void initialize() {
        nom.setText("");
        prenom.setText("");
        adresse.setText("");
        email.setText("");
        password.setText("");  
    }
    
    @FXML
    private void onClick() {
         User user=new User(nom.getText(),prenom.getText(),adresse.getText(),email.getText(),password.getText());
        UserDao userDao=new UserDao();
        userDao.insert(user);
        System.out.println(nom.getText()+" "+prenom.getText()+" "+adresse.getText()+" "+email.getText()+" "+password.getText()+"");
        initialize();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
