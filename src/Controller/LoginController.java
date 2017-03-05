/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tech Devil
 */
public class LoginController implements Initializable {
    
    
    
//    Users users = new Users();                                                ************************************************

    
    
    
     @FXML
    private TextField tfUserName;
    @FXML
    private Button btnUserNameTfClear;
    @FXML
    private Button btnPassFieldClear;
    @FXML
    private PasswordField pfUserPassword;

//    CustomTf cTF = new CustomTf();                                            **********************************
//    CustomPf cPF = new CustomPf();
    
    
    
    @FXML
    private Button btnLogin;
    
    
    
    private PreparedStatement pst;
    private Connection con;
    private ResultSet rs;
    @FXML
    private AnchorPane apMother;
    @FXML
    private AnchorPane apDesignPane;
    @FXML
    private Hyperlink hlCrateAccount;

    
//    DBProperties dBProperties = new DBProperties();                           ******************************
//    String db = dBProperties.loadPropertiesFile();
    @FXML
    private Hyperlink hlDatabase;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO                                                                 ********************************
    }    

    @FXML
    private void hlCreateAnAccount(ActionEvent event) {
//                                                                                *******************************
    }
    
    @FXML
    private void pfUserNameOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pfUserPassOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        //                                                                      *************************************************
    }
    
    
    @FXML
    private void hlDbOnAction(ActionEvent event) {
        //                                                                      ************************************************
    }
}
