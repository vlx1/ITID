package factories;

import dao.UserDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Viktor on 17.11.2016.
 */
public class DaoFactory {
    private static DaoFactory instance;

    private UserDao userDao;
    private Properties properties;


    static {
        instance = new DaoFactory();
    }

    private DaoFactory() {
        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\DaoTask\\src\\main\\resources\\components.properties"));
            String daoClassName = properties.getProperty("dao.class");

            this.userDao = (UserDao) Class.forName(daoClassName).newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public static DaoFactory getInstance()
    {
        return instance;
    }
}
