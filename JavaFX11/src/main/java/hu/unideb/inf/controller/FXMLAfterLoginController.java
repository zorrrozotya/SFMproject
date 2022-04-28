package hu.unideb.inf.controller;

        import com.sun.xml.fastinfoset.stax.events.CommentEvent;
        import hu.unideb.inf.model.Movies;
        import hu.unideb.inf.model.User;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TabPane;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;

        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class FXMLAfterLoginController implements Initializable {

    @FXML
    private Button addSearchedButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button AddButton1;

    @FXML
    private Button addSearched;

    @FXML
    private Button AddButton12;

    @FXML
    private Button searchButton;

    @FXML
    private TextField FilmDescription;

    @FXML
    private TextField FilmGenre;

    @FXML
    private TextField searchText;

    @FXML
    private TextField FilmName;

    @FXML
    private Button Logoutbutton;

    @FXML
    private Label msg;

    @FXML
    private Label msg1;

    @FXML
    private Label userLabel;

    @FXML
    public static Label staticUserLabel;

    @FXML
    private Label searchLabel;

    @FXML
    private TabPane tabpane;

    @FXML
    private Pane scenePane;


    @FXML
    void handleAddSearchedButton(ActionEvent event) {

    }

    @FXML
    void handleSearchButton(ActionEvent event) throws SQLException {
        System.out.println("kereses megnyomva");
        Movies m = Movies.searchMovie(searchText.getText());
        if(m == null){
            searchLabel.setText("Nincs ilyen film");
            addSearchedButton.setVisible(false);
        }
        else{
            searchLabel.setText(m.getTitle());
            addSearchedButton.setVisible(true);
        }
    }

    Stage stage;
    @FXML
    public void handleLogoutButtonPushed(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Sikeres kijelentkezes!");
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staticUserLabel = userLabel;
    }

    public void handleAddButton(ActionEvent actionEvent) {

    }
}
