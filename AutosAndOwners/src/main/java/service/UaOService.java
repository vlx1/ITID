package service;

import model.Owner;

import java.io.IOException;

/**
 * Created by Viktor on 26.11.2016.
 */
public interface UaOService {
    boolean isOwnerRegistered(String name) throws IOException;
    void addOwner(Owner owner) throws IOException;
    Owner getOwner(int id) throws IOException;
    void updateOwner(Owner owner) throws IOException;
}
