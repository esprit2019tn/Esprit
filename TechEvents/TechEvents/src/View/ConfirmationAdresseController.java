/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class ConfirmationAdresseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField codeConfirmation;

    @FXML
    private JFXTextField email;

    @FXML
    private Label msgErreur;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    public void setEmail(String email) {
        this.email.setText(email);
    }
    
    
    
    
    @FXML
    void confirmer(ActionEvent event) {
        
        UserDao userDao=new UserDao();
        String confCode=userDao.getConfirmationCode(email.getText());
        if(confCode!=null){
            if(confCode.equals(codeConfirmation.getText()))
                    userDao.setConfirmationEmail(email.getText());
            else{
                msgErreur.setText("Code de confirmation incorrecte");
                msgErreur.setTextFill(Color.RED);
            }
        }
        else{
                msgErreur.setText("Email incorrecte");
                msgErreur.setTextFill(Color.RED);
        }

        
            
        
        
        

    }
    
    
    
}
