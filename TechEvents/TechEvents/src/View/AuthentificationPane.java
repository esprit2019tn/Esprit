/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author AYMEN
 */
public class AuthentificationPane extends AnchorPane {
    
    
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label btnForgot;

    @FXML
    private Label lblErrors;
    
    public AuthentificationPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthentificationPane.fxml"));
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
        email.setText("");
        password.setText("");  
    }
    
    @FXML
    private void SignIn() {
        UserDao userDao=new UserDao();
        User user=userDao.findUser(email.getText(), password.getText());
        String m="";
        if(user!=null){
            m="connecté avec succès";
           // msg.setTextFill(Color.web("#0076a3"));
        }
        else{
            m="Email ou mot de passe incorrect";
           // msg.setTextFill(Color.web("#0076a3"));
        }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(m);
            //alert.setContentText(m);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        initialize();
    }
    
        @FXML
    private void SignUp() {
      //  String[] args=null;
        //Inscription.main(args);
        
    }
}
