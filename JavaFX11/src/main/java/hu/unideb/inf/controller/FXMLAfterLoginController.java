package hu.unideb.inf.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TabPane;
        import javafx.scene.control.TextField;

        import java.net.URL;
        import java.util.ResourceBundle;

public class FXMLAfterLoginController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private Button AddButton1;

    @FXML
    private Button AddButton12;

    @FXML
    private Button AddButton121;

    @FXML
    private TextField FilmDescription;

    @FXML
    private TextField FilmGenre;

    @FXML
    private TextField FilmName;

    @FXML
    private Button Logoutbutton;

    @FXML
    private Label msg;

    @FXML
    private Label msg1;

    @FXML
    private TabPane tabpane;

    @FXML
    void handleAddButton(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
