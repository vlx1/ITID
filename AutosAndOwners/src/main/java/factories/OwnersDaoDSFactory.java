package factories;

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
public class OwnersDaoDSFactory {
    private static OwnersDaoDSFactory instance;
    private OwnersDao ownersDao;
    private Properties properties;

    static {
        instance = new OwnersDaoDSFactory();
    }
    private OwnersDaoDSFactory(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\AutosAndOwners\\src\\main\\resources\\application.properties"));
            String daoOwnersClassName = properties.getProperty("owners.dao.class");
            Constructor constructor = Class.forName(daoOwnersClassName).getConstructor(DataSource.class);
            ownersDao = (OwnersDao) constructor.newInstance(DataSourceFactory.getInstance().getDataSource());
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

    public OwnersDao getOwnersDao() {
        return ownersDao;
    }
    public static OwnersDaoDSFactory getInstance() {
        return instance;
    }

}
