package dao;

import model.Owner;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 20.11.2016.
 */
public interface OwnerDao {
    List<Owner> findAll() throws IOException;
    void save(Owner owner) throws IOException;
    void update(Owner owner) throws IOException;
    void delete(int id) throws IOException;
    Owner find(int id) throws IOException;
}
