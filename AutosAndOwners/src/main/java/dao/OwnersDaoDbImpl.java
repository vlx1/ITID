package dao;

import model.Owner;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 26.11.2016.
 */
public class OwnersDaoDbImpl implements OwnersDao {
    private Connection connection = null;
    List<Owner> owners = new ArrayList<Owner>();

    // language=SQL
    private final static String SQL_SELECT_OWNERS = "SELECT * FROM autorussia.owners;";
    // language=SQL
    private final static String SQL_SELECT_OWNER = "SELECT * FROM autorussia.owners WHERE id=?;";
    // language=SQL
    private final static String SQL_INSERT_OWNER = "INSERT INTO autorussia.owners(name, age, city) VALUES (?,?,?); ";
    // language=SQL
    private  final  static String SQL_UPDATE_OWNER = "UPDATE autorussia.owners SET name=?, age = ?, city = ? WHERE id = ?;";
    // language=SQL
    private final static String SQL_DELETE_OWNER = "DELETE FROM autorussia.owners WHERE id=?;";
    public OwnersDaoDbImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Owner> findAll() throws IOException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_OWNERS);

            while (resultSet.next()) {
                owners.add(new Owner(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getInt("age"), resultSet.getString("city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }
    public void save(Owner owner) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_OWNER);
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setInt(2, owner.getAge());
            preparedStatement.setString(3, owner.getCity());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void update(Owner owner) throws IOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_OWNER);
            preparedStatement.setInt(4, owner.getId());
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setInt(2, owner.getAge());
            preparedStatement.setString(3, owner.getCity());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    };
    public void delete(int id) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_OWNER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    };
    public Owner find(int id) throws IOException {
        PreparedStatement preparedStatement = null;
        Owner owner = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_OWNER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                owner = new Owner(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getInt("age"),resultSet.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owner;
    }
}
