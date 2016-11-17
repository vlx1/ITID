package factories;

import dao.UserDao;
import service.UserService;
import service.UsersService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by Viktor on 18.11.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    private UserService usersService;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        Properties properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\DaoTask\\src\\main\\resources\\components.properties"));
            String serviceClassName = properties.getProperty("service.class");

            Class serviceClass = Class.forName(serviceClassName);

            Constructor constructor = serviceClass.getConstructor(UserDao.class);
            UserDao userDao = DaoFactory.getInstance().getUserDao();

            this.usersService = (UsersService)constructor.newInstance(userDao);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public UserService getUsersService() {
        return usersService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
