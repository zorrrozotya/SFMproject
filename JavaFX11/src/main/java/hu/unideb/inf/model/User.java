package hu.unideb.inf.model;

import hu.unideb.inf.controller.FXMLAfterLoginController;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Entity
public class User {

    public static String currentUserName;
    public static int currentUserId;

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    private int seensum;
    private int screentime;


    public Integer getId() {
        return this.id;
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

    public static boolean checkName(String name){
        boolean r = false;
        if(name.length() > 5 && name.length() < 15){
            char[] namearray = name.toCharArray();
            for(char c : namearray){
                if(Character.isLetter(c) == false && Character.isDigit(c) == false){
                    r = true;
                    System.out.println("Rossz felhasznalonev");
                    break;
                }
            }

        }
        else{
            r = true;
        }



        return r;
    }

    public static boolean checkPassword(String password) {
        boolean r = false;
        if(password.length() < 5 || password.length() > 15){
            r = true;
            System.out.println("Rossz jelszo");
        }
        return r;
    }

    public static int User_Register(String name, String password)
    {

        int s = 0;  // 0 = sikeres regisztr??ci??,
                    // 1 = M??r l??tezik ilyen felhaszn??l?? ,
                    // 2 = Nem megfelel?? form??tum?? adatok

        if(checkName(name) == true || checkPassword(password) == true){
            s = 2; //  --  nem megfelel?? a form??tum
        }
        else{
            try (UserDAO uDAO = new JpaUserDao())
            {
                List<User> users = getUsers();
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).userName.equalsIgnoreCase(name))
                    {
                        s = 1; //  --  ilyen felhaszn??l?? m??r van
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

        int s = 1;  // 0 = Sikeres bejelentkez??s
                    // 1 = Nincs ilyen felhaszn??l??n??v
                    // 2 = T??ves jelsz??

        List<User> Users = getUsers();

        for (int i = 0; i < Users.size(); i++) {

            if(Users.get(i).userName.equals(name)) {

                if(Users.get(i).password.equals(password)){
                    s = 0;

                    currentUserName = Users.get(i).userName;

                    break;
                    //  --  sikeres bejelentkez??s
                }

                else{
                    s = 2;
                    break;
                    // -- t??ves jelsz??
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
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            int seenSum = resultSet.getInt("SeenSum");
            int screenTime = resultSet.getInt("ScreenTime");
            user.setUserName(userName);
            user.setPassword(password);
            user.setScreentime(screenTime);
            user.setSeensum(seenSum);
            user.setId(id);

            Users.add(user);
        }
        return Users;
    }






}
