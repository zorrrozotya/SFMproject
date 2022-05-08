package hu.unideb.inf.model;

public interface UserDAO extends AutoCloseable{

    public void saveUser(User a);
    public void deleteUser(User a);
    public void updateUser(User a);

    public void saveMovie(Movies a);
    public void deleteMovie(Movies a);
    public void updateMovie(Movies a);


}
