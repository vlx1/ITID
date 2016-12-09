package factories;

import dao.CarsDao;
import dao.OwnersDao;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by Viktor on 30.11.2016.
 */
public class CarsDaoDSFactory {
    private static CarsDaoDSFactory instance;
    private CarsDao carsDao;
    private Properties properties;

    static {
        instance = new CarsDaoDSFactory();
    }

    private CarsDaoDSFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\AutosAndOwners\\src\\main\\resources\\application.properties"));
            String daoCarsClassName = properties.getProperty("cars.dao.class");
            Constructor constructor = Class.forName(daoCarsClassName).getConstructor(DataSource.class);
            carsDao = (CarsDao) constructor.newInstance(DataSourceFactory.getInstance().getDataSource());
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

    public CarsDao getCarsDao() {
        return carsDao;
    }
    public static CarsDaoDSFactory getInstance() {
        return instance;
    }
}
