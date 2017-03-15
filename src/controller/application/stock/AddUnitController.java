/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.stock;

import Setup.UnitSetup;
import java.net.URL;
import java.util.ResourceBundle;

import Gateway.UnitGateway;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import media.userNameMedia;
import custom.*;
import dataBase.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import Data.Unit;

/**
 *
 * @author Tech Devil
 */
public class AddUnitController implements Initializable {

    Unit unit = new Unit();
    UnitGateway unitGateway = new UnitGateway();
    UnitSetup unitSetup = new UnitSetup();

    public String unitId;
    @FXML
    public Button btnSave;
    @FXML
    private TextField tfUnitName;
    
    @FXML
    private Button btnClrUnitName;
    
    private String usrId;
    
    private userNameMedia nameMedia;
    
    CustomTf ctf = new CustomTf();
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    @FXML
    private TextArea taDescription;
    @FXML
    public Button btnUpdate;
    @FXML
    public Label lblContent;
    @FXML
    private Button btnClose;

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(userNameMedia nameMedia) {
        usrId =  nameMedia.getId();
        this.nameMedia = nameMedia;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ctf.clearTextFieldByButton(tfUnitName, btnClrUnitName);
        BooleanBinding bb = tfUnitName.textProperty().isEmpty();
        btnSave.disableProperty().bind(bb);

    }    

    @FXML
    private void btnSaveOnAction(ActionEvent event) {

        unit.unitName = tfUnitName.getText().trim();
        unit.unitDescription = taDescription.getText().trim();
        unit.creatorId = usrId;
        unitSetup.save(unit);
        
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        
        unit.id = unitId;
        unit.unitName = tfUnitName.getText().trim();
        unit.unitDescription =taDescription.getText().trim();
        unitGateway.update(unit);
        
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        
    }


    public void showDetails() {
        
        unit.id = unitId;
        unitGateway.selectedView(unit);
        tfUnitName.setText(unit.unitName);
        taDescription.setText(unit.unitDescription);
        
    }

}
