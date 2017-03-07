/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Blob;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author Tech Devil
 */
public class Users {
    
    public ObservableList<String> allUser = FXCollections.observableArrayList();
    //public ObservableList<ListEmployee> employeeLists = FXCollections.observableArrayList();
    
    
    public String id;
    public String userName;
    public String fullName;
    public String emailAddress;
    public String contactNumber;
    public String salary;
    public String address;
    public String password;
    public String status;
    public String imagePath;
    public Blob userImage;
    public String date;
    public String creatorId;
    public Image image;
    
}
