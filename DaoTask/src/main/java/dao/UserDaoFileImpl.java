package dao;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


/**
 * Created by Viktor on 15.11.2016.
 */
public class UserDaoFileImpl implements UserDao {
    List<User> users;
    private final String path = "C:\\Users\\Viktor\\Desktop\\ITIS\\DaoTask\\src\\main\\resources\\fileUsers";


    public UserDaoFileImpl() throws IOException {
        this.users = this.findAll();
    }

    public List<User> findAll() throws IOException {
        File f = new File(path);
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;
        ArrayList<User> userArrayList = new ArrayList<User>();
        while ((line = fin.readLine()) != null) {
            //System.out.println(line);
            String[] lines = line.split(" ");
            User newUser = new User(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3]);
            userArrayList.add(newUser);
        }
        return userArrayList;
    }

    public void save(User user) throws IOException {
        StringBuilder userAsString = new StringBuilder();
        userAsString.append(user.getId()+ " " + user.getName() + " " +
                user.getLogin() + " " + user.getPassword()).append("\r\n");
        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(userAsString.toString());
        bufferWriter.close();
        //users.add(userForSave);
    }

    public void update(User user) throws IOException {

        for(User userForUpdate : users) {
            if (user.getId() == userForUpdate.getId() )
            {
                userForUpdate.setName(user.getName());
                userForUpdate.setPassword(user.getPassword());
                userForUpdate.setLogin(user.getLogin());
            }
        }
        this.cleanFile();
        for (User userForUpdate : users) {
            this.save(userForUpdate);
        }
    }

    public void delete(int id) throws IOException {
        List<User> users1 = this.findAll();
        for(User user : users1)
        {
            if(id == user.getId()) {
                users1.remove(user);
                break;
            }
        }
        this.cleanFile();
        for (User user : users1) {
            this.save(user);
        }
        users = users1;
    }

    public User find(int id) throws IOException {
        //List<User> usersSearch = this.findAll();
        for(User searchingUser : users) {
            if (id == searchingUser.getId() )
            {
                return searchingUser;
            }
        }
        return null;
    }

    private void cleanFile() throws IOException {
        FileWriter fstream1 = new FileWriter(path);
        BufferedWriter out1 = new BufferedWriter(fstream1);
        out1.write("");
        out1.close();
    }
}
