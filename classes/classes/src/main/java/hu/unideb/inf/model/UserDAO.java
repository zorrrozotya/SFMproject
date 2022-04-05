package hu.unideb.inf.model;

import java.util.Optional;

public interface UserDAO extends AutoCloseable{

    public void saveUser(User a);
    public void deleteUser(User a);
    public void updateUser(User a);

}
