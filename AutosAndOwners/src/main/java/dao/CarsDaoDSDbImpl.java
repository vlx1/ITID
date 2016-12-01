package dao;

import model.Car;
import model.Owner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Viktor on 30.11.2016.
 */
public class CarsDaoDSDbImpl implements CarsDao {

    // шаблон для работы с базами данных
    private NamedParameterJdbcTemplate template;

    private Map<Integer, Car> carMap;

    // language=SQL
    private final static String SQL_SELECT_CARS = "SELECT * FROM autorussia.cars;";
    // language=SQL
    private final static String SQL_SELECT_CAR = "SELECT * FROM autorussia.cars WHERE id= :id;";
    // language=SQL
    private final static String SQL_INSERT_CAR = "INSERT INTO autorussia.cars(model, mileage, ownerID) VALUES (:model, :mileage, :ownerID); ";
    // language=SQL
    private  final  static String SQL_UPDATE_CAR = "UPDATE autorussia.cars SET model=?, mileage = ?, ownerID = ? WHERE id = ?;";
    // language=SQL
    private final static String SQL_DELETE_CAR = "DELETE FROM autorussia.cars WHERE id= :id;";

    public CarsDaoDSDbImpl(DataSource dataSource){
        template = new NamedParameterJdbcTemplate(dataSource);
        carMap = new HashMap<Integer, Car>();
    }

    RowMapper<Car> carRowMapper = new RowMapper<Car>() {
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = new Car(resultSet.getInt("id"),resultSet.getString("model"),
                    resultSet.getInt("mileage"),resultSet.getInt("ownerId"));
            carMap.put(car.getId(), car);
            return car;
        }
    };


    public List<Car> findAll() throws IOException {
        template.query(SQL_SELECT_CARS, carRowMapper);
        return new ArrayList<Car>(carMap.values());
    }

    public void save(Car car) throws IOException {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("model",car.getModel());
        params.put("mileage", car.getMileage());
        params.put("ownerID", car.getOwnerId());
        template.update(SQL_INSERT_CAR, params);
    }

    public void update(Car car) throws IOException {

    }

    public void delete(int id) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        template.update(SQL_DELETE_CAR, params);
    }

    public Car find(int id) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return template.queryForObject(SQL_SELECT_CAR, params, carRowMapper);
    }
}
