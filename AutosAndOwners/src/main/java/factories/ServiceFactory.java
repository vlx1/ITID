package factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import service.*;
import dao.*;

/**
 * Created by Viktor on 26.11.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    Properties properties;
    UaOService service;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\AutosAndOwners\\src\\main\\resources\\application.properties"));
            String serviceClassName = properties.getProperty("service.class");
            Constructor constructor = Class.forName(serviceClassName).getConstructor(OwnersDao.class, CarsDao.class);
            service = (UaOService) constructor.newInstance(OwnersDaoDSFactory.getInstance().getOwnersDao(), CarsDaoDSFactory.getInstance().getCarsDao());
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

    public UaOService getService() {
        return service;
    }
    public static ServiceFactory getInstance() {
        return instance;
    }
}
