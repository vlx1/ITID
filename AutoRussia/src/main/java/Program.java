import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


/**
 * Created by Viktor on 20.11.2016.
 */
public class Program {

    // language=SQL
    private final static String SQL_SELECT_OWNERS = "SELECT * FROM autorussia.owners;";
    // language=SQL
    private final static String SQL_INSERT_OWNER = "INSERT INTO autorussia.owners(name, age, city) VALUES (?,?,?); ";
    private final static String URL = "jdbc:mysql://localhost:3306/autorussia";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            // эти две строки заменить на Class.forName("...")
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            //

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_OWNERS);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("name") + ", "
                        + resultSet.getInt("age") + ", " + resultSet.getString("city"));
            }

            preparedStatement = connection.prepareStatement(SQL_INSERT_OWNER);
            preparedStatement.setString(1, "John");
            preparedStatement.setInt(2, 55);
            preparedStatement.setString(3, "Kazan");

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Неудалось загрузить класс драйвера.");
        }

        //System.out.println(connection.isClosed());
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.execute("INSERT INTO autorussia.owners(name, age, city) VALUES ('John', 55, 'FordMustang');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
