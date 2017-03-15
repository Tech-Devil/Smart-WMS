/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Data.Brands;
import Data.Supplier;
import List.ListBrands;
import dataBase.DBConnection;
import dataBase.DBProperties;
import dataBase.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 *
 * @author Tech Devil
 */
public class BrandsGateway {

    SQL sql = new SQL();

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    DBProperties dBProperties = new DBProperties();
    String db = dBProperties.loadPropertiesFile();

    public void save(Brands brands) {

        con = dbCon.geConnection();
        brands.supplyrId = sql.getIdNo(brands.supplierName, brands.supplyrId, "Supplier", "SupplierName");
        try {
            pst = con.prepareStatement("insert into " + db + ".Brands values(?,?,?,?,?,?)");
            pst.setString(1, null);
            pst.setString(2, brands.brandName);
            pst.setString(3, brands.brandComment);
            pst.setString(4, brands.supplyrId);
            pst.setString(5, brands.creatorId);
            pst.setString(6, LocalDate.now().toString());
            pst.executeUpdate();
            con.close();
            pst.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Saved");
            alert.setContentText("Brand" + "  '" + brands.brandName + "' " + "Added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void view(Brands brands) {

        con = dbCon.geConnection();
        try {
            pst = con.prepareCall("select * from " + db + ".Brands");
            rs = pst.executeQuery();
            while (rs.next()) {
                brands.id = rs.getString(1);
                brands.brandName = rs.getString(2);
                brands.brandComment = rs.getString(3);
                brands.supplyrId = rs.getString(4);
                brands.creatorId = rs.getString(5);
                brands.date = rs.getString(6);
                brands.supplierName = sql.getName(brands.supplyrId, brands.supplierName, "Supplier");
                brands.creatorName = sql.getName(brands.creatorId, brands.creatorName, "User");
                brands.brandDitails.addAll(new ListBrands(brands.id, brands.brandName, brands.brandComment, brands.supplierName, brands.creatorName, brands.date));
            }
            con.close();
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void selectedView(Brands brands) {

        con = dbCon.geConnection();
        try {
            con = dbCon.geConnection();
            pst = con.prepareCall("select * from " + db + ".Brands where id=?");
            pst.setString(1, brands.id);
            rs = pst.executeQuery();
            while (rs.next()) {
                brands.id = rs.getString(1);
                brands.brandName = rs.getString(2);
                brands.brandComment = rs.getString(3);
                brands.supplyrId = rs.getString(4);
                brands.supplierName = sql.getName(brands.supplyrId, brands.supplierName, "Supplier");
            }
            con.close();
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void searchView(Brands brands) {

        con = dbCon.geConnection();
        brands.brandDitails.clear();
        System.out.println("name :" + brands.brandName);
        try {
            con = dbCon.geConnection();
            pst = con.prepareCall("select * from " + db + ".Brands where BrandName like ? ORDER BY BrandName");
            System.out.println("Brand name in Brand Object");
            pst.setString(1, "%" + brands.brandName + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                brands.id = rs.getString(1);
                brands.brandName = rs.getString(2);
                brands.brandComment = rs.getString(3);
                brands.supplyrId = rs.getString(4);
                brands.creatorId = rs.getString(5);
                brands.date = rs.getString(6);
                brands.supplierName = sql.getName(brands.supplyrId, brands.supplierName, "Supplier");
                brands.creatorName = sql.getName(brands.creatorId, brands.creatorName, "User");
                brands.brandDitails.addAll(new ListBrands(brands.id, brands.brandName, brands.brandComment, brands.supplierName, brands.creatorName, brands.date));
            }
            con.close();
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(Brands brands) {
        
        con = dbCon.geConnection();
        try {
            pst = con.prepareStatement("delete from " + db + ".Brands where Id=?");
            pst.setString(1, brands.id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void update(Brands brands) {
        
        con = dbCon.geConnection();
        try {
            pst = con.prepareStatement("update " + db + ".Brands set BrandName=? , Description=?,SupplierId=? where Id=?");
            pst.setString(1, brands.brandName);
            pst.setString(2, brands.brandComment);
            pst.setString(3, brands.supplyrId);
            pst.setString(4, brands.id);
            pst.executeUpdate();
            con.close();
            pst.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Updated");
            alert.setContentText("Update" + "  '" + brands.brandName + "' " + "Added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public boolean isNotUsed(Brands brands) {
        
        con = dbCon.geConnection();
        boolean inNotUse = false;
        try {
            pst = con.prepareStatement("select * from " + db + ".Category where BrandId=?");
            pst.setString(1, brands.id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Already exist ");
                alert.setContentText("Brand" + "  '" + brands.brandName + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return inNotUse;
            }
            rs.close();
            pst.close();
            con.close();
            inNotUse = true;
        } catch (SQLException ex) {
            Logger.getLogger(BrandsGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inNotUse;
        
    }

}
