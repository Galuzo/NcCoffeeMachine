package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.dao.implementations.UserDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;

/**
 * Created by Win on 18.04.2017.
 */
public class CheckUserService {
    public static User isRegistered(String login) throws DaoException {
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            User user=userDao.getByName(login);
            if (user!= null) {
                return user;
            }
            else return null;
        } catch (DaoException e ) {
            throw new DaoException("User was not found");
        }
    }
}
