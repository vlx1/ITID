package factories;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Viktor on 22.11.2016.
 */
public class ConnectionFactory {

    private static ConnectionFactory instance;

    private Connection connection;

    private Properties properties;

    static {
        try {
            instance = new ConnectionFactory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ConnectionFactory() throws SQLException {
        properties = new Properties();
        try {
            properties.load(new FileInputStream
                    ("C:\\Users\\Viktor\\IdeaProjects\\AutoRussia\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driverName = properties.getProperty("database.driver");
        String url = properties.getProperty("database.url");
        String login = properties.getProperty("database.login");
        String password = properties.getProperty("database.password");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(url, login, password);
    }
    public Connection getConnection() {
        return connection;
    }
    public static ConnectionFactory getInstance() {
        return instance;
    }
}
