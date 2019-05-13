/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dhiae
 */
public class ReclamationController implements Initializable {

    @FXML
    private JFXHamburger humburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  vbox = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        drawer.setSidePane(vbox);
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(humburger);
        transition.setRate(-1);
        humburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            
            if (drawer.isHidden()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });

    }    
    
}
