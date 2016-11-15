package model;

import com.google.common.base.MoreObjects;

/**
 * Created by Viktor on 15.11.2016.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String name;

    public User (int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.name)
                .add("login", this.login).add("password", this.password).toString();
    }
}
