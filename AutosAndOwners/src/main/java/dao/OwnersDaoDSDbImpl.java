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
public class OwnersDaoDSDbImpl implements OwnersDao {


    // шаблон для работы с базами данных
    private NamedParameterJdbcTemplate template;

    private Map<Integer, Owner> ownerMap;

    // language=SQL
    private final static String SQL_SELECT_OWNERS = "SELECT * FROM owners;";
    // language=SQL
    private final static String SQL_SELECT_OWNER = "SELECT * FROM autorussia.owners WHERE id=?;";
    // language=SQL
    private final static String SQL_INSERT_OWNER = "INSERT INTO autorussia.owners(name, age, city) VALUES (?,?,?); ";
    // language=SQL
    private  final  static String SQL_UPDATE_OWNER = "UPDATE autorussia.owners SET name=?, age = ?, city = ? WHERE id = ?;";
    // language=SQL
    private final static String SQL_DELETE_OWNER = "DELETE FROM autorussia.owners WHERE id=?;";

    public OwnersDaoDSDbImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
        ownerMap = new HashMap<Integer, Owner>();
    }

    RowMapper<Owner> ownerRowMapper = new RowMapper<Owner>() {
        public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            int userAge = resultSet.getInt("age");
            String userCity = resultSet.getString("city");
            Owner owner = new Owner(userId, userName, userAge, userCity);
            ownerMap.put(owner.getId(), owner);
            return owner;

            /*
            Owner owner = new Owner(resultSet.getInt("id"),resultSet.getString("name"),
                    resultSet.getInt("age"), resultSet.getString("city"), new ArrayList<Car>());
            ownerMap.put(owner.getId(), owner);
            return owner; */
        }
    };

    public List<Owner> findAll() throws IOException {
        template.query(SQL_SELECT_OWNERS, ownerRowMapper);
        return new ArrayList<Owner>(ownerMap.values());
    }

    public void save(Owner owner) throws IOException {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("name",owner.getName());
        params.put("age", owner.getAge());
        params.put("city", owner.getCity());
        template.update(SQL_INSERT_OWNER, params);

    }

    public void update(Owner owner) throws IOException {

    }

    public void delete(int id) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        template.update(SQL_DELETE_OWNER, params);
    }

    public Owner find(int id) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return template.queryForObject(SQL_SELECT_OWNER, params, ownerRowMapper);
    }
}
