package factories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Viktor on 28.11.2016.
 */
public class DataSourceFactory {
    private static DataSourceFactory instance;
    private DataSource dataSource;
    private Properties properties;

    static {
        instance = new DataSourceFactory();
    }
    private DataSourceFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Viktor\\Desktop\\ITIS\\AutosAndOwners\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driverName = properties.getProperty("database.driver");
        String url = properties.getProperty("database.url");
        String name = properties.getProperty("database.login");
        String password = properties.getProperty("database.password");


        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(name);
        driverManagerDataSource.setPassword(password);

        this.dataSource = driverManagerDataSource;
    }

    public static DataSourceFactory getInstance(){
        return instance;
    }
    public DataSource getDataSource(){
        return dataSource;
    }
}
