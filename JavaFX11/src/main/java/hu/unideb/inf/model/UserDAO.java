package hu.unideb.inf.model;

import javax.management.relation.Relation;

public interface UserDAO extends AutoCloseable{

    public void saveUser(User a);
    public void deleteUser(User a);
    public void updateUser(User a);

    public void saveMovie(Movies a);
    public void deleteMovie(Movies a);
    public void updateMovie(Movies a);

    public void saveRelation(Relations a);
    public void deleteRelation(Relations a);
    public void updateRelation(Relations a);

}
