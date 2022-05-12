package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movies {

    public static int seensum;

    @Id
    @GeneratedValue
    private Integer id;
    private String Title;
    private int LengthHour;
    private int LengthMin;
    private String genre;
    private int release;
    private String About;


    public void setRelease(int release) {
        this.release = release;
    }




    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getLengthHour() {
        return LengthHour;
    }

    public void setLengthHour(int lengthh) {
        this.LengthHour = lengthh;
    }

    public double getLengthMin() {
        return LengthMin;
    }

    public void setLengthMin(int lengthm) {
        this.LengthMin = lengthm;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }


    //Film keresése
    public static Movies searchMovie(String searchedTitle) throws SQLException {
        Movies r = null;
        List<Movies> Movies = getMovies();
        for(Movies m : Movies){
            if(m.getTitle().contains(searchedTitle)) r = m;
            System.out.println(m.getTitle()+" "+m.getId());
        }
        return r;
    }


    //Filmek összegyűjtése az adatbázisból
    public static List<Movies> getMovies() throws SQLException {
        String jdbcURL = "jdbc:h2:file:~/my_database";

        Connection connection = DriverManager.getConnection(jdbcURL, "sa", "");
        String sql = "SELECT * FROM MOVIES";
        List<Movies> Movies = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next())
        {
            Movies movie = new Movies();
            String title = resultSet.getString("title");
            int release = Integer.parseInt(resultSet.getString("release"));
            int lengthh = resultSet.getInt("lengthhour");
            int lengthm = resultSet.getInt("lengthmin");
            movie.setTitle(title);
            movie.setRelease(release);
            movie.setLengthHour(lengthh);
            movie.setLengthMin(lengthm);
            Movies.add(movie);
        }
        return Movies;
    }

}
