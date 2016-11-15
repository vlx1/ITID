package dao;

import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 15.11.2016.
 */
public interface UserDao {
    List<User> findAll() throws IOException;
    void save(User user) throws IOException;
    void update(User user) throws IOException;
    void delete(int id) throws IOException;
    User find(int id) throws IOException;

}
