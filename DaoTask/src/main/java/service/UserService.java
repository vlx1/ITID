package service;

import model.User;

import java.io.IOException;

/**
 * Created by Viktor on 15.11.2016.
 */
public interface UserService {
    boolean isRegistered(String name) throws IOException;
    void addUser(User user) throws IOException;
    User getUser(int id) throws IOException;

}
