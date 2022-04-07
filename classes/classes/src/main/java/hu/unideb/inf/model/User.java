package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public void User_Register(String name, String password)
    {
        try (UserDAO uDAO =new JpaUserDao())
        {
            User user = new User();
            // már felhasznált felhasználónévvel történő regisztráció tiltás

            String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

            Connection connection = DriverManager.getConnection(jdbcURL, "sa", "1234");
            String sql = "SELECT * FROM USER";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                String userName = resultSet.getString("userName");
                if(userName.equals(name))
                {
                    // controlleren keresztül, írja ki hogy ilyen felhasználó már van.
                }
                else  // ---  ha nincs ilyen név akkor tudjon regisztrálni
                {
                    user.userName=name;
                    user.password=password;
                    uDAO.saveUser(user);
                }
            }

            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
