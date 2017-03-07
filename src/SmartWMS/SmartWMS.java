/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartWMS;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import DataBase.DBModel;

/**
 *
 * @author Tech Devil
 */
public class SmartWMS extends Application {
    
    
    public SmartWMS() {
        DBModel model = new DBModel();
        model.createDataBase();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Smart Warehouse Management System");
            primaryStage.getIcons().add(new Image("/Images/icon.png"));
            primaryStage.setMaximized(false);
            primaryStage.setMinHeight(500.0);
            primaryStage.setMinWidth(850.0);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(SmartWMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
