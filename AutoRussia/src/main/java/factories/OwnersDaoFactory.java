package factories;

import dao.OwnerDao;
import model.Owner;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Viktor on 22.11.2016.
 */
public class OwnersDaoFactory {
    private static OwnersDaoFactory instance;
    Properties properties;
    OwnerDao ownerDao;

    static {
        instance = new OwnersDaoFactory();
    }

    private OwnersDaoFactory()
    {
        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\Viktor\\IdeaProjects\\AutoRussia\\src\\main\\resources\\application.properties"));
            String ownersClassName = properties.getProperty("owners.dao.class");
            Constructor constructor = Class.forName(ownersClassName).getConstructor(Connection.class);
            ownerDao = (OwnerDao) constructor.newInstance(ConnectionFactory.getInstance().getConnection());
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
    public OwnerDao getOwnerDao() {
        return ownerDao;
    }

}
