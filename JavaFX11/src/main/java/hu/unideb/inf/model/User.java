package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {

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

        int siker = 1;

        try (UserDAO uDAO = new JpaUserDao())
        {
            List<User> users = getUsers();
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).userName.toLowerCase().equals(name))
                {
                    siker = 0; //  ---  ilyen felhasználó már van
                }
            }
            if(siker == 1){
                User user = new User();
                user.setUserName(name);
                user.setPassword(password);
                uDAO.saveUser(user);
            }


        } catch (Exception e){
            e.printStackTrace();
        }


        return siker;   //  --  hozzáadva a database-hez
    }


    public static int User_Login(String name, String password) throws SQLException {
        List<User> Users = new ArrayList<>();
        Users = getUsers();
        for (int i = 0; i < Users.size(); i++) {
            if(Users.get(i).userName.equals(name) && Users.get(i).password.equals(password))
            {
                return 1;//  --  sikeres bejelentkezés
            }
        }

        return 0;  //  --  sikertelen bejelentkezés

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
