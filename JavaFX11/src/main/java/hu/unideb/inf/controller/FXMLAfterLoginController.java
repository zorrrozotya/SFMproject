package hu.unideb.inf.controller;

        import com.sun.xml.fastinfoset.stax.events.CommentEvent;
        import hu.unideb.inf.model.Movies;
        import hu.unideb.inf.model.Relations;
        import hu.unideb.inf.model.User;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;

        import java.net.URL;
        import java.sql.SQLException;
        import java.util.List;
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
    private Label AddMovieErrorLabel;

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
    private ListView<String> moveListDisplay;

    @FXML
    private Label seensum;

    @FXML
    private Label screentime;


    public static Movies lastSeached;



    @FXML
    void handleAddSearchedButton(ActionEvent event) throws SQLException, InterruptedException {
        System.out.println("ezeket adja hozza a relationshoz");
        System.out.println("user: "+User.currentUserName);
        System.out.println("Movie: "+lastSeached.getTitle());
        Relations relation = new Relations(User.currentUserName, lastSeached.getTitle());
        int success = Relations.addRelation(relation);
        if(success == 0 ) {
            AddMovieErrorLabel.setVisible(true);
        }
        refreshList();
    }

    @FXML
    void handleSearchButton(ActionEvent event) throws SQLException {
        AddMovieErrorLabel.setVisible(false);
        System.out.println("kereses megnyomva");
        Movies m = Movies.searchMovie(searchText.getText());
        if(m == null){
            searchLabel.setText("Nincs ilyen film");
            addSearchedButton.setVisible(false);
        }
        else{
            searchLabel.setText(m.getTitle());

            lastSeached = m;
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

    private void refreshList(){

        moveListDisplay.getItems().clear();

        List<String> seenMovies = null;
        System.out.println("Neki kell hozzaadni: "+userLabel.getText());
        try {
            seenMovies = Relations.loadMovies(User.currentUserName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Ezeket kell hozzaadni:");

        moveListDisplay.getItems().addAll(seenMovies);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staticUserLabel = userLabel;

        refreshList();

    }

    public void handleAddButton(ActionEvent actionEvent) {

    }
}
