package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Entity
public class User {

    public static String currentUserName;

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    private int seensum;
    private int screentime;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getSeensum() {
        return seensum;
    }

    public void setSeensum(int seensum) {
        this.seensum = seensum;
    }

    public int getScreentime() {
        return screentime;
    }

    public void setScreentime(int screentime) {
        this.screentime = screentime;
    }


    public static int User_Register(String name, String password)
    {

        int s = 0;  // 0 = sikeres regisztráció,
                    // 1 = Már létezik ilyen felhasználó ,
                    // 2 = Nem megfelelő formátumú adatok

        if(name.length() < 5 || password.length() < 8 || name.length() > 15 || password.length() > 15){
            s = 2; //  --  nem megfelelő a formátum
        }
        else{
            try (UserDAO uDAO = new JpaUserDao())
            {
                List<User> users = getUsers();
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).userName.equalsIgnoreCase(name))
                    {
                        s = 1; //  --  ilyen felhasználó már van
                        break;
                    }
                }

                if(s == 0){
                    User user = new User();
                    user.setUserName(name);
                    user.setPassword(password);
                    uDAO.saveUser(user);
                }


            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return s;
    }


    public static int User_Login(String name, String password) throws SQLException {

        int s = 1;  // 0 = Sikeres bejelentkezés
                    // 1 = Nincs ilyen felhasználónév
                    // 2 = Téves jelszó

        List<User> Users = getUsers();

        for (int i = 0; i < Users.size(); i++) {

            if(Users.get(i).userName.equals(name)) {

                if(Users.get(i).password.equals(password)){
                    s = 0;
                    currentUserName = Users.get(i).userName;
                    break;
                    //  --  sikeres bejelentkezés
                }

                else{
                    s = 2;
                    break;
                    // -- téves jelszó
                }

            }

        }

        return s;
    }

    public static List<User> getUsers() throws SQLException {
        String jdbcURL = "jdbc:h2:file:~/my_database";

        Connection connection = DriverManager.getConnection(jdbcURL, "sa", "");
        String sql = "SELECT * FROM USER";
        List<User> Users = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            User user = new User();
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            user.setUserName(userName);
            user.setPassword(password);
            Users.add(user);
        }
        return Users;
    }
}
