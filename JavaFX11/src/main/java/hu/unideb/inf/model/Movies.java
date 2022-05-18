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


    //getterek és setterek

    public Integer getId() {
        return this.id;
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

    public void setRelease(int release) {
        this.release = release;
    }

    public int getRelease() {
        return release;
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

    //screentime szamitas h
    public static int calculateScreenTimeHour(int h,int m){
        int hour = h + m/60;
        return hour;
    }
    //screentime szamitas min
    public static int calculateScreenTimeMin(int h, int m){
        int min= m%60;
        return min;
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

    //Uj film regisztrálása
    public static int Movie_Register(String title, String genre, String release, String lengthh, String lengthmin, String description)
    {

        int s = 0;  // 0 = sikeres regisztráció,
        // 1 = Már létezik ilyen felhasználó ,
        // 2 = Nem megfelelő formátumú adatok

        if(description.length() < 10 || description.length() > 200){
            s = 2; //  --  nem megfelelő a formátum
        }
        else{
            try (UserDAO uDAO = new JpaUserDao())
            {
                List<Movies> movies = getMovies();
                for (int i = 0; i < movies.size(); i++) {
                    if(movies.get(i).getTitle().equalsIgnoreCase(title))
                    {
                        s = 1; //  --  ilyen film már van
                        break;
                    }
                }

                if(s == 0){
                    Movies movie = new Movies();
                    movie.setTitle(title);
                    movie.setGenre(genre);
                    movie.setRelease(Integer.parseInt(release));
                    movie.setLengthHour(Integer.parseInt(lengthh));
                    movie.setLengthMin(Integer.parseInt(lengthmin));
                    movie.setAbout(description);

                    uDAO.saveMovie(movie);
                }


            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return s;
    }


    //Film torlese
    public static int deleteMovie(String title) throws SQLException {

        int s = 0;

        String jdbcURL = "jdbc:h2:file:~/my_database";

        Connection connection = DriverManager.getConnection(jdbcURL, "sa", "");
        String sql = "DELETE FROM MOVIES WHERE TITLE='"+title+"'";
        String sql2 = "DELETE FROM RELATIONS WHERE MOVIE_TITLE='"+title+"'";

        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.execute(sql2);


        return s;
    }

}
