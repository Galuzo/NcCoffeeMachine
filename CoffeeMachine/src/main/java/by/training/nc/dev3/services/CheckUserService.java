package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.dao.implementations.UserDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;
import filters.UserType;

/**
 * Created by Win on 18.04.2017.
 */
public class CheckUserService {
    public static User isRegistered(String login)  {
        UserDaoImpl userDao = new UserDaoImpl();
        User user=null;
        try {
            user=userDao.getByName(login);

        } catch (Exception e ) {
           return null;
        }
        return user;
    }

    public static UserType defineRole(User user) {
        UserType userType=null;
        switch (user.getIdRoles()) {
            case 1:
                userType=UserType.ClIENT;
                break;
            case 2:
                userType = UserType.ADMINISTRATOR;
                break;

        }
        return userType;
    }
}
