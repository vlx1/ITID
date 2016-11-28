package dao;

import java.io.IOException;
import java.util.List;

import model.Owner;

/**
 * Created by Viktor on 26.11.2016.
 */
public interface OwnersDao {
    List<Owner> findAll() throws IOException;
    void save(Owner owner) throws IOException;
    void update(Owner owner) throws IOException;
    void delete(int id) throws IOException;
    Owner find(int id) throws IOException;
}
