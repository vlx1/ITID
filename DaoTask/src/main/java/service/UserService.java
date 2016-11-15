package service;

import java.io.IOException;

/**
 * Created by Viktor on 15.11.2016.
 */
public interface UserService {
    boolean isRegistered(String name) throws IOException;
}
