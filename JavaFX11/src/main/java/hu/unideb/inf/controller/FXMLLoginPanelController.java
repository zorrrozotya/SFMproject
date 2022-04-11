package hu.unideb.inf.controller;

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
    private TextField LoginNameText;

    @FXML
    private PasswordField LoginPasswordText;

    @FXML
    private Button RegisterButton;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TabPane tabpanelogin;

    @FXML
    private TextField usernameText;

    @FXML
    void HandleLogInButoon(ActionEvent event) throws SQLException{

        System.out.println(LoginNameText.getText());
        System.out.println(LoginPasswordText.getText());
        int a = User.User_Login(LoginNameText.getText(),LoginPasswordText.getText());
        System.out.println(a);
    }

    @FXML
    void HandleRegisterButton(ActionEvent event) throws SQLException {

        System.out.println(usernameText.getText());
        System.out.println(passwordText.getText());
        int a = User.User_Register(usernameText.getText(),passwordText.getText());
        System.out.println(a);

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
