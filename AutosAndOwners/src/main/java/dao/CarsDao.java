package dao;

import java.io.IOException;
import java.util.List;

import model.Car;

/**
 * Created by Viktor on 26.11.2016.
 */
public interface CarsDao {
    List<Car> findAll() throws IOException;
    void save(Car car) throws IOException;
    void update(Car car) throws IOException;
    void delete(int id) throws IOException;
    Car find(int id) throws IOException;
}
