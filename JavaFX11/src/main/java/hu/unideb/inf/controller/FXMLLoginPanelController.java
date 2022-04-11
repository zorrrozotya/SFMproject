package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.net.URL;
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
    void HandleLogInButoon(ActionEvent event) {

    }

    @FXML
    void HandleRegisterButton(ActionEvent event) {
        System.out.println("Na csumi");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
