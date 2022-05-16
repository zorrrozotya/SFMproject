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
        import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

        import java.net.URL;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ResourceBundle;

public class FXMLAfterLoginController implements Initializable {

    @FXML
    private Button addSearchedButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button AddButton1;

    @FXML
    private Button addSearched;

    @FXML
    private Button searchToDeleteButton;

    @FXML
    private Button searchButton;
    
    @FXML
    private Button Logoutbutton;

    @FXML
    private TextField FilmDescription;

    @FXML
    private TextField FilmGenre;

    @FXML
    private TextField searchText;

    @FXML
    private TextField FilmName;

    @FXML
    private TextField searchToDeleteText;

    @FXML
    private TextField FilmRelease;

    @FXML
    private TextField FilmLengthH;

    @FXML
    private TextField FilmLengthMin;

    @FXML
    private Label msg;

    @FXML
    private Label AddMovieErrorLabel;

    @FXML
    private Label msg1;

    @FXML
    private Label userLabel;

    @FXML
    private Label seensumLabel;

    @FXML
    private Label stLabel;

    @FXML
    private Label searchLabel;

    @FXML
    private Label ErrorRegText;

    @FXML
    private Label searchToDeleteLabel;

    @FXML
    private Label DeleteDisplayLabel;


    @FXML
    public static Label staticUserLabel;

    @FXML
    private TabPane tabpane;

    @FXML
    private Pane scenePane;

    @FXML
    private ListView<String> moveListDisplay;
    
    public static Movies lastSearched;

    public FXMLAfterLoginController() {
    }

    @FXML
    void handleAddSearchedButton(ActionEvent event) throws SQLException, InterruptedException {
        System.out.println("ezeket adja hozza a relationshoz");
        System.out.println("user: "+User.currentUserName);
        System.out.println("Movie: "+lastSearched.getTitle());
        Relations relation = new Relations(User.currentUserName, lastSearched.getTitle());
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

            lastSearched = m;
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
        try {
            seenMovies = Relations.loadMovies(User.currentUserName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Movies.seensum = seenMovies.size();
        moveListDisplay.getItems().addAll(seenMovies);
        setSeenSum();
        try {
            setScreenTime();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSeenSum(){
        int value = 0;
        value = Movies.seensum;
        seensumLabel.setText(value+" filmet láttál eddig");
    }

    public void setScreenTime() throws SQLException {

        int hvalue = 0;
        int minvalue = 0;

        List<Movies> osszes = Movies.getMovies();
        List<String> seenMovies = Relations.loadMovies(User.currentUserName);

        for(Movies m : osszes){
            if(seenMovies.contains(m.getTitle())){

                hvalue+=m.getLengthHour();
                minvalue+=m.getLengthMin();
            }
        }

        System.out.println(minvalue);

        hvalue=Movies.calculateScreenTimeHour(hvalue,minvalue);
        minvalue=Movies.calculateScreenTimeMin(hvalue,minvalue);
        stLabel.setText(hvalue+" órát és "+minvalue+" percet töltöttél filmnézéssel");

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        staticUserLabel = userLabel;

        refreshList();

    }

    public void handleAddButton(ActionEvent actionEvent) {

        System.out.println("Film hozzáadás gomb megnyomva");
        System.out.println("Film cime: "+FilmName.getText());
        System.out.println("Film mufaj: "+FilmGenre.getText());
        System.out.println("Film hossz ora: "+FilmDescription.getText());
        System.out.println("Film hossz perc: "+FilmLengthH.getText());
        System.out.println("Film leiras: "+FilmLengthMin.getText());


        int s = Movies.Movie_Register(FilmName.getText(),FilmGenre.getText(),
                                    FilmRelease.getText(),
                                    FilmLengthH.getText(),
                                    FilmLengthMin.getText(),
                                    FilmDescription.getText());

        System.out.println(s);
        switch(s){
            case 0 :
                System.out.println("Sikeres film regisztracio!");
                ErrorRegText.setStyle("-fx-text-fill: green;");
                ErrorRegText.setText("Sikeres film regisztáció!");
                break;
            case 1 :
                System.out.println("Mar letezik ilyen film!");
                ErrorRegText.setStyle("-fx-text-fill: red;");
                ErrorRegText.setText("Már létezik ilyen film!");
                break;
            case 2:
                System.out.println("Nem megfelelő formátumú adatok!");
                ErrorRegText.setStyle("-fx-text-fill: red;");
                ErrorRegText.setText("Nem megfelelő formátumú adatok!");
                break;
        }


    }

    public void handleDeleteButton(ActionEvent actionEvent) throws SQLException {
        System.out.println("torles megnyomva");
        String title = searchToDeleteLabel.getText();
        int s = Movies.deleteMovie(title);

        switch(s){
            case 0 :
                System.out.println("Sikeres film torles!");
                DeleteDisplayLabel.setStyle("-fx-text-fill: green;");
                DeleteDisplayLabel.setText("Sikeres film törlés!");
                break;
            case 1 :
                System.out.println("Sikertelen film torles!");
                DeleteDisplayLabel.setStyle("-fx-text-fill: red;");
                DeleteDisplayLabel.setText("Sikertelen film törlés!");
                break;
        }
        refreshList();
    }

    public void handleSearchToDeleteButton(ActionEvent actionEvent) throws SQLException {
        System.out.println("kereses torleshez megnyomva");

        Movies m = Movies.searchMovie(searchToDeleteText.getText());
        if(m == null){
            searchToDeleteLabel.setText("Nincs ilyen film");
            DeleteButton.setVisible(false);
        }
        else {
            searchToDeleteLabel.setText(m.getTitle());
            DeleteButton.setVisible(true);
        }
    }

}
