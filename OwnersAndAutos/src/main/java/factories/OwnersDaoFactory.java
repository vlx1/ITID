package factories;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;
import dao.*;

/**
 * Created by Viktor on 26.11.2016.
 */
public class OwnersDaoFactory {
    private static OwnersDaoFactory instance;
    Properties properties;
    OwnersDao ownerDao;

    static {
        instance = new OwnersDaoFactory();
    }

    private OwnersDaoFactory()
    {
        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\Viktor\\IdeaProjects\\AutosAndOwners\\src\\main\\resources\\application.properties"));
            String ownersClassName = properties.getProperty("owners.dao.class");
            Constructor constructor = Class.forName(ownersClassName).getConstructor(Connection.class);
            ownerDao = (OwnersDao) constructor.newInstance(ConnectionFactory.getInstance().getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static OwnersDaoFactory getInstance() {
        return instance;
    }
    public OwnersDao getOwnerDao() {
        return ownerDao;
    }
}
