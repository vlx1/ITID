package dao;

import model.Car;
import model.Owner;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 20.11.2016.
 */
public interface CarDao {
    List<Car> findAll() throws IOException;
    void save(Car car) throws IOException;
    void update(Car car) throws IOException;
    void delete(int id) throws IOException;
    Car find(int id) throws IOException;
}
