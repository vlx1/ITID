package dao;

import model.Car;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 26.11.2016.
 */
public class CarsDaoDbImpl implements CarsDao {
    private Connection connection = null;
    List<Car> cars = new ArrayList<Car>();

    // language=SQL
    private final static String SQL_SELECT_CARS = "SELECT * FROM autorussia.cars;";
    // language=SQL
    private final static String SQL_SELECT_CAR = "SELECT * FROM autorussia.cars WHERE id=?;";
    // language=SQL
    private final static String SQL_INSERT_CAR = "INSERT INTO autorussia.cars(model, mileage, ownerID) VALUES (?,?,?); ";
    // language=SQL
    private  final  static String SQL_UPDATE_CAR = "UPDATE autorussia.cars SET model=?, mileage = ?, ownerID = ? WHERE id = ?;";
    // language=SQL
    private final static String SQL_DELETE_CAR = "DELETE FROM autorussia.cars WHERE id=?;";
    public CarsDaoDbImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Car> findAll() throws IOException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CARS);

            while (resultSet.next()) {
                cars.add(new Car(resultSet.getInt("id"),resultSet.getString("model"),
                        resultSet.getInt("mileage"), resultSet.getInt("ownerId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public void save(Car car) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_CAR);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getMileage());
            preparedStatement.setInt(3, car.getOwnerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void update(Car car) throws IOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_CAR);
            preparedStatement.setInt(4, car.getId());
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getMileage());
            preparedStatement.setInt(3, car.getOwnerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    };
    public void delete(int id) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    };
    public Car find(int id) throws IOException {
        PreparedStatement preparedStatement = null;
        Car car = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_CAR);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car(resultSet.getInt("id"),resultSet.getString("model"),
                        resultSet.getInt("mileage"),resultSet.getInt("ownerId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}
