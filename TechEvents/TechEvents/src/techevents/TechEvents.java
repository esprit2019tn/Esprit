/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techevents;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AYMEN
 */
public class TechEvents extends Application{


    
        @Override
    public void start(Stage stage) throws Exception {//AccueilEvent
        Parent root = FXMLLoader.load(getClass().getResource("../View/AccueilEvent.fxml"));
        Scene scene = new Scene(root);
            stage.setTitle("TechEvent"); 

    // Set the application icon.
    stage.getIcons().add(new Image("file:resources/img/TechEvent.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
