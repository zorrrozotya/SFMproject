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

    List<User> users = new ArrayList<>();

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
        try (UserDAO uDAO =new JpaUserDao();)
        {
            User user = new User();
            // már felhasznált felhasználónévvel történő regisztráció tiltás
            for (int i = 0; i<=users.size(); i++)
            {
                if (users.get(i).userName.equals(name))
                {
                    // controllernek küldés, hogy már van ilyen felhasználó
                }
                else
                {
                    user.userName=name;
                    user.password=password;
                    uDAO.saveUser(user);
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
