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
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class Publication extends Application{
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         Parent root = FXMLLoader.load(getClass().getResource("/View/ListePublication.fxml"));
         Scene scene = new Scene(root,900,950);
         //scene.getStylesheets().add(getClass().getResource("").toExternalForm());

        // scene = new Scene(root,800,700) ;
         //scene.getStylesheets().add(get1lass().getResource("").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
