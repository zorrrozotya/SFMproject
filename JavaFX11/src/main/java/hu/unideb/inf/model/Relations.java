package hu.unideb.inf.model;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Relations {

    @Id
    @GeneratedValue
    private Integer id;

    private String user_Name;
    private String movie_Title;


    public Relations(String username, String movieTitle) {
        this.user_Name = username;
        this.movie_Title = movieTitle;
    }

    //Adott emberhez tartozó filmek listája
    public static List<String> loadMovies(String username) throws SQLException {
        List<String> r = new ArrayList<>();

        List<Relations> rel = getRelations();

        for(Relations relation : rel){
            if(relation.user_Name.equals(username)) r.add(relation.movie_Title);
        }

        return r;
    }

    //új reláció
    public static void addRelation(Relations r){

        try (UserDAO uDAO = new JpaUserDao())
        {

            uDAO.saveRelation(r);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public static List<Relations> getRelations() throws SQLException {
        String jdbcURL = "jdbc:h2:file:~/my_database";

        Connection connection = DriverManager.getConnection(jdbcURL, "sa", "");
        String sql = "SELECT * FROM RELATIONS";
        List<Relations> Relations = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {

            String userName = resultSet.getString("user_Name");
            String movieTitle = resultSet.getString("movie_Title");
            Relations relation = new Relations(userName, movieTitle);
            Relations.add(relation);
        }
        return Relations;
    }

}
