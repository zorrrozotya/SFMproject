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


            a.setUserName("Jani");
            a.setPassword("alma");
            uDAO.saveUser(a);


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
