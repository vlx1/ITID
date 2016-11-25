package factories;

import dao.CarDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Viktor on 23.11.2016.
 */
public class CarsDaoFactory {
    private static CarsDaoFactory instance;
    Properties properties;
    CarDao carDao;

    static {
        instance = new CarsDaoFactory();
    }

    private CarsDaoFactory()
    {
        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\Viktor\\IdeaProjects\\AutoRussia\\src\\main\\resources\\application.properties"));
            String carsClassName = properties.getProperty("cars.dao.class");
            Constructor constructor = null;
            constructor = Class.forName(carsClassName).getConstructor(Connection.class);
            carDao = (CarDao) constructor.newInstance(ConnectionFactory.getInstance().getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static CarsDaoFactory getInstance() {
        return instance;
    }
    public CarDao getCarDao() {
        return carDao;
    }
}
