/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Users;
import DataBase.DBConnection;
import DataBase.DBProperties;
import Gateway.UsersGateway;
import Media.UserNameMedia;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Tech Devil
 */
public class ApplicationController implements Initializable {

    @FXML
    private AnchorPane acMain;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private ScrollPane leftSideBarScrollPane;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmplopye;
    @FXML
    private ImageView imgEmployeeBtn;
    @FXML
    private Button btnSales;
    @FXML
    private ImageView imgSalesBtn;
    @FXML
    private Button btnSettings;
    @FXML
    private ImageView imgSettingsBtn;
    @FXML
    private Button btnAbout;
    @FXML
    private ImageView imgAboutBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acHead;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Button btnLogOut;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Label lblUsrName;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private Label lblUserId;
    @FXML
    private StackPane acContent;

    String usrName;
    String id;

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    DBProperties dBProperties = new DBProperties();
    String db = dBProperties.loadPropertiesFile();

    Users users = new Users();
    UsersGateway usersGetway = new UsersGateway();

    private UserNameMedia usrNameMedia;

    public UserNameMedia getUsrNameMedia() {
        return usrNameMedia;
    }

    public void setUsrNameMedia(UserNameMedia usrNameMedia) {
        lblUserId.setText(usrNameMedia.getId());
        lblUsrName.setText(usrNameMedia.getUsrName());
        id = usrNameMedia.getId();
        usrName = usrNameMedia.getUsrName();

        this.usrNameMedia = usrNameMedia;
    }

    Image menuImage = new Image("/Icon/menu.png");
    Image menuImageSelected = new Image("/Icon/menuSelected.png");
    Image image;

    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";

    Image home = new Image("/Icon/Home.png");
    Image homeSelected = new Image("/Icon/HomeSelected.png");
    Image stock = new Image("/Icon/Stock.png");
    Image stockSelected = new Image("/Icon/StockSelected.png");
    Image sales = new Image("/Icon/Sales.png");
    Image salesSelected = new Image("/Icon/SalesSelected.png");
    Image employee = new Image("/Icon/Employee.png");
    Image employeeSelected = new Image("/Icon/EmployeeSelected.png");
    Image settings = new Image("/Icon/Settings.png");
    Image settingsSelected = new Image("/Icon/SettingsSelected.png");
    Image about = new Image("/Icon/About.png");
    Image aboutSelected = new Image("/Icon/AboutSelected.png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        imgMenuBtn.setImage(menuImage);
    }

    @FXML
    private void btnHomeOnClick(ActionEvent event) throws IOException {

        homeActive();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.load(getClass().getResource("/View/Application/Home.fxml").openStream());
        AnchorPane root = fxmlLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(root);
        System.out.println(lblUsrName.getText());
        System.out.println(lblUserId.getText());

    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) throws IOException {

        sotreActive();
//        StockController sc = new StockController();
        UserNameMedia nm = new UserNameMedia();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Application/Stock.fxml").openStream());
        nm.setId(id);
//        StockController stockController = fXMLLoader.getController();
//        stockController.bpStore.getStylesheets().add("/Style/MainStyle.css");
//        stockController.setUserId(usrNameMedia);
//        stockController.btnStockOnAction(event);
//        stockController.settingPermission();
        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);

    }

    @FXML
    private void btnEmplopyeOnClick(ActionEvent event) throws IOException {

        employeeActive();
//        EmployeeController ec = new EmployeeController();
        UserNameMedia nm = new UserNameMedia();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Application/Employee.fxml").openStream());
        nm.setId(id);
//        EmployeeController employeeController = fXMLLoader.getController();
//        employeeController.bpContent.getStylesheets().add("/Style/MainStyle.css");
//        employeeController.setNameMedia(usrNameMedia);
//        employeeController.btnViewEmployeeOnAction(event);
        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);

    }

    @FXML
    private void btnSalesOnClick(ActionEvent event) throws IOException {

        salesActive();
//        SellController controller = new SellController();
        UserNameMedia nm = new UserNameMedia();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Sales.fxml").openStream());
        nm.setId(id);
//            SellController sellController = fXMLLoader.getController();
//            sellController.setNameMedia(usrNameMedia);
//            sellController.acMainSells.getStylesheets().add("/style/MainStyle.css");
//            sellController.tbtnSellOnAction(event);
        AnchorPane anchorPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(anchorPane);

    }

    @FXML
    private void btnSettingsOnClick(ActionEvent event) throws IOException {

        settingsActive();
//        SettingsController settingController = new SettingsController();
        UserNameMedia usrMedia = new UserNameMedia();
        FXMLLoader settingLoader = new FXMLLoader();
        settingLoader.load(getClass().getResource("/View/Application/Settings.fxml").openStream());
        usrMedia.setId(id);
//        SettingsController settingControl = settingLoader.getController();
//        settingControl.bpSettings.getStylesheets().add("/Style/MainStyle.css");
//        settingControl.setUsrMedia(usrMedia);
//        settingControl.miMyASccountOnClick(event);
//        settingControl.settingPermission();
        AnchorPane acPane = settingLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);

    }

    @FXML
    private void btnAboutOnClick(ActionEvent event) throws IOException {

        aboutActive();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Application/About.fxml").openStream());
        AnchorPane anchorPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(anchorPane);

    }

    @FXML
    private void hlUpdateAccount(ActionEvent event) {
    }

    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {

        acContent.getChildren().clear();
        acContent.getChildren().add(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
        acDashBord.getChildren().clear();
        acHead.getChildren().clear();
        acHead.setMaxHeight(0.0);

    }

    @FXML
    private void mbtnOnClick(ActionEvent event) {
    }

    @FXML
    private void sideMenuToogleBtnOnCLick(ActionEvent event) {

        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageSelected);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(-130);
            sideMenu.play();
            acDashBord.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(130);
            sideMenu.play();
            acDashBord.getChildren().add(leftSideBarScrollPane);
        }

    }

    @FXML
    private void acMain(KeyEvent event) {

        if (event.getCode() == KeyCode.F11) {
            Stage stage = (Stage) acMain.getScene().getWindow();
            stage.setFullScreen(true);
        }

    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {
    }

    private void homeActive() {
        imgHomeBtn.setImage(homeSelected);
        imgStoreBtn.setImage(stock);
        imgSalesBtn.setImage(sales);
        imgEmployeeBtn.setImage(employee);
        imgSettingsBtn.setImage(settings);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(activeStyle);
        btnStore.setStyle(defultStyle);
        btnSales.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void sotreActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stockSelected);
        imgSalesBtn.setImage(sales);
        imgEmployeeBtn.setImage(employee);
        imgSettingsBtn.setImage(settings);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(activeStyle);
        btnSales.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void salesActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSalesBtn.setImage(salesSelected);
        imgEmployeeBtn.setImage(employee);
        imgSettingsBtn.setImage(settings);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSales.setStyle(activeStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void employeeActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSalesBtn.setImage(sales);
        imgEmployeeBtn.setImage(employeeSelected);
        imgSettingsBtn.setImage(settings);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSales.setStyle(defultStyle);
        btnEmplopye.setStyle(activeStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void settingsActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSalesBtn.setImage(sales);
        imgEmployeeBtn.setImage(employee);
        imgSettingsBtn.setImage(settingsSelected);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSales.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(activeStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void aboutActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSalesBtn.setImage(sales);
        imgEmployeeBtn.setImage(employee);
        imgSettingsBtn.setImage(settings);
        imgAboutBtn.setImage(aboutSelected);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSales.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(activeStyle);
    }

//    public void viewDetails() {
//        users.id = id;
//        UsersGateway.selectedView(users);
//        image = users.image;
//        circleImgUsr.setFill(new ImagePattern(image));
//        imgUsrTop.setFill(new ImagePattern(image));
//        lblFullName.setText(users.fullName);
//        lblUsrNamePopOver.setText(users.userName);
//    }
}
