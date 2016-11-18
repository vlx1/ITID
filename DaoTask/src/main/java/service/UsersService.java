package service;

import dao.UserDao;
import model.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 15.11.2016.
 */
public class UsersService implements UserService {
    private UserDao usersDao;

    public UsersService(UserDao usersDao)
    {
        this.usersDao = usersDao;
    }

    public boolean isRegistered(String name) throws IOException {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if(currentUser.getName().equals(name))
                return true;
        }
        return false;
    }

    public void addUser(User user) throws IOException {
        usersDao.save(user);
    }

    public void updateUser(User user) throws IOException {
        usersDao.update(user);
    }

    public User getUser(int id) throws IOException {
        //verifier.userExist(id);
        return usersDao.find(id);
    }
}
