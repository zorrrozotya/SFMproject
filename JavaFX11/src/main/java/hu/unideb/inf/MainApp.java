package hu.unideb.inf;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.unideb.inf.model.Movies;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/login_panel.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Movie - Login");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        try {
            startDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        launch(args);
        stopDatabase();
    }

    private static Server s = new Server();

    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }

}