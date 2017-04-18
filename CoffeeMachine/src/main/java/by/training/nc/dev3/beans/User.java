package by.training.nc.dev3.beans;

import by.training.nc.dev3.beans.Entity;

/**
 * Created by Win on 10.04.2017.
 */
public class User extends Entity {
    private String login;
    private String password;
    private long idRoles;

    public User(){}
    public User(int id, String login, String password, long idRoles) {
        super(id);
        this.login = login;
        this.password = password;
        this.idRoles = idRoles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(long idRoles) {
        this.idRoles = idRoles;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", idRoles=" + idRoles +
                '}';
    }
}
