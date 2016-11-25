package service;

import dao.CarDao;
import dao.OwnerDao;
import model.Car;
import model.Owner;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 22.11.2016.
 */
// TODO: ServiceImpl
public class UsersAndAutosServiceMySQLImpl implements UsersAndAutosService {

    private OwnerDao ownerDao;
    private CarDao carDao;

    public UsersAndAutosServiceMySQLImpl(OwnerDao ownerDao, CarDao carDao)
    {
        this.ownerDao = ownerDao;
        this.carDao = carDao;
    }

    public boolean isOwnerRegistered(String name) throws IOException {
        List<Owner> owners = ownerDao.findAll();

        for (Owner currentOwner : owners) {
            if(currentOwner.getName().equals(name))
                return true;
        }
        return false;
    }

    public void addOwner(Owner owner) throws IOException {
        ownerDao.save(owner);
    }

    public Owner getOwner(int id) throws IOException {
        return ownerDao.find(id);
    }

    public void updateOwner(Owner owner) throws IOException {
        ownerDao.update(owner);
    }

    public boolean isCarRegistered(String model) throws IOException {
        List<Car> cars = carDao.findAll();

        for (Car currentCar : cars) {
            if(currentCar.getModel().equals(model))
                return true;
        }
        return false;
    }

    public void addCar(Car car) throws IOException {
        carDao.save(car);
    }

    public Car getCar(int id) throws IOException {
        return carDao.find(id);
    }

    public void updateCar(Car car) throws IOException {
        carDao.update(car);
    }
}
