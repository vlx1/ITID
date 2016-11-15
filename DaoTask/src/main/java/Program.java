/**
 * Created by Viktor on 15.11.2016.
 */
import dao.UserDao;
import dao.UserDaoArrayListImpl;
import model.*;
import service.UsersService;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        User alex = new User(4, "Alex", "alexLogin", "qwerty01");
        User john = new User(5, "John", "johnLogin", "qwerty02");
        //User paul = new User(6, "Paul", "paulLogin", "qwerty03");

        UserDao usersDao = new UserDaoArrayListImpl();

        usersDao.save(alex);
        usersDao.save(john);
        //usersDao.save(paul);
        usersDao.delete(3);
        usersDao.update(new User(2, "BorisEl", "borisElLogin", "1991SE"));

        UsersService usersService = new UsersService(usersDao);

        if (usersService.isRegistered("Boris")) {
            System.out.println("Boris is Registered");
        }
        else {
            System.out.println("Boris is not Registered");
        }



    }
}
