package hu.unideb.inf;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.model.JpaUserDao;
import hu.unideb.inf.model.User;
import hu.unideb.inf.model.UserDAO;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        //try with resources
        try (UserDAO uDAO =new JpaUserDao();){
            User a=new User();
            User b=new User();
            User c=new User();
            User d=new User();


            a.setUserName("Zsollesz");
            a.setPassword("alma123");
            a.setSeensum(3);
            a.setScreentime(10);
            uDAO.saveUser(a);

            b.setUserName("Tomcsa");
            b.setPassword("kukc12");
            b.setSeensum(2);
            b.setScreentime(5);
            uDAO.saveUser(b);

            c.setUserName("Szabesz");
            c.setPassword("helo2342");
            c.setSeensum(3);
            c.setScreentime(7);
            uDAO.saveUser(c);

            d.setUserName("Zollee");
            d.setPassword("anya<3");
            d.setSeensum(1);
            d.setScreentime(3);
            uDAO.saveUser(d);


        } catch (Exception e) {
            e.printStackTrace();
        }


        /*
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        User customer = new User();
        customer.setUserName("Dennys");
        customer.setPassword("Fredericci");

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: "); */

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
