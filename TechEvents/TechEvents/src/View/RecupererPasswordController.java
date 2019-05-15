/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Entity.User;
import Metier.EmailSend;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AYMEN
 */
public class RecupererPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField email;

    @FXML
    private Label msgErreur;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    void confirmer(ActionEvent event) throws IOException {
        
        UserDao userDao=new UserDao();
        User user=userDao.findUserByEmail(email.getText()) ;
        if(user!=null)
            EmailSend.sendRecuperMail(email.getText(),user.getPassword());
        
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
    }
    
}
