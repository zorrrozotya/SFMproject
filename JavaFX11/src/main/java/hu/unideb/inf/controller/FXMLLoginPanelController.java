package hu.unideb.inf.controller;

import hu.unideb.inf.model.Movies;
import hu.unideb.inf.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FXMLLoginPanelController implements Initializable {

    @FXML
    private Label ErrorLogText;

    @FXML
    private Label ErrorRegText;

    @FXML
    private Button LogInButton;

    @FXML
    private TextField LoginUsernameText;

    @FXML
    private PasswordField LoginPasswordText;

    @FXML
    private Button RegisterButton;

    @FXML
    private PasswordField RegisterPasswordText;

    @FXML
    private TabPane tabpanelogin;

    @FXML
    private TextField RegisterUsernameText;

    @FXML
    void HandleRegisterButton(ActionEvent event) throws SQLException {

        System.out.println("Register gomb megnyomva");
        System.out.println("Felhasználónév: "+RegisterUsernameText.getText());
        System.out.println("Jelszó: "+RegisterPasswordText.getText());

        int s = User.User_Register(RegisterUsernameText.getText(),RegisterPasswordText.getText());

        System.out.println(s);
        switch(s){
            case 0 :
                System.out.println("Sikeres regisztráció");
                break;
            case 1 :
                System.out.println("Már létezik ilyen felhasználó");
                break;
            case 2:
                System.out.println("Nem megfelelő formátumú adatok");
                break;
        }
    }//RegisterButton vége


    @FXML
    void HandleLogInButoon(ActionEvent event) throws SQLException{

        System.out.println("Login gomb megnyomva");
        System.out.println("Felhasznalonev: "+LoginUsernameText.getText());
        System.out.println("Jelszo: "+LoginPasswordText.getText());

        int s = User.User_Login(LoginUsernameText.getText(),LoginPasswordText.getText());
        System.out.println(s);

        switch(s){
            case 0 :
                System.out.println("Sikeres bejelentkezés");
                break;
            case 1 :
                System.out.println("Nincs ilyen felhasználónév");
                break;
            case 2:
                System.out.println("Téves jelszó");
                break;
        }

    }//LoginButton vége


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
