package factories;

import dao.CarDao;
import dao.OwnerDao;
import service.UsersAndAutosService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by Viktor on 22.11.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    Properties properties;
    UsersAndAutosService service;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\AutoRussia\\src\\main\\resources\\application.properties"));
            String serviceClassName = properties.getProperty("service.class");
            Constructor constructor = Class.forName(serviceClassName).getConstructor(OwnerDao.class, CarDao.class);
            service = (UsersAndAutosService) constructor.newInstance(OwnersDaoFactory.getInstance().getOwnerDao(), CarsDaoFactory.getInstance().getCarDao());
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UsersAndAutosService getService() {
        return service;
    }
    public static ServiceFactory getInstance() {
        return instance;
    }
}
