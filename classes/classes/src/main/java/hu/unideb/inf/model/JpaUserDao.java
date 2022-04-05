package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaUserDao implements UserDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();



    @Override
    public void saveUser(User a) {

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(User a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User a) {
        saveUser(a);
    }

    @Override
    public void close() throws Exception {

    }
}
