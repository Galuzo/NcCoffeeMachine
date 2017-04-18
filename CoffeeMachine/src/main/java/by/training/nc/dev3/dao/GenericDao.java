package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.Entity;
import by.training.nc.dev3.exceptions.DaoException;

import java.util.List;

/**
 * Created by Win on 14.04.2017.
 */
public interface GenericDao <T extends Entity> {
    public T persist(T object)  throws DaoException;
    public T getByPK(int key) throws DaoException;
    public void update(T object) throws DaoException;
    public void delete(T object) throws DaoException;
    public List<T> getAll() throws DaoException;
}
