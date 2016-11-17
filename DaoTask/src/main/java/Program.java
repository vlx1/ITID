/**
 * Created by Viktor on 15.11.2016.
 */
import dao.UserDao;
import dao.UserDaoFileImpl;
import factories.ServiceFactory;
import model.*;
import service.UserService;
import service.UsersService;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        /*
        UserDao usersDao = new UserDaoFileImpl();

        usersDao.delete(3);
        usersDao.update(new User(2, "BorisEl", "borisElLogin", "1991SE"));

        UsersService usersService = new UsersService(usersDao);
*/
        UserService userService = ServiceFactory.getInstance().getUsersService();

        User alex = new User(4, "Alex", "alexLogin", "qwerty01");
        User john = new User(5, "John", "johnLogin", "qwerty02");
        //User paul = new User(6, "Paul", "paulLogin", "qwerty03");

        userService.addUser(alex);
        userService.addUser(john);
        //usersDao.save(paul);


        if (userService.isRegistered("Boris")) {
            System.out.println("Boris is Registered");
        }
        else {
            System.out.println("Boris is not Registered");
        }



    }
}
