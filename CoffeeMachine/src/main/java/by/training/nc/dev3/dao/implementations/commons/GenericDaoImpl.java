package by.training.nc.dev3.dao.implementations.commons;

import by.training.nc.dev3.beans.Entity;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.dao.GenericDao;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Win on 14.04.2017.
 */
public abstract class GenericDaoImpl<T extends Entity> implements GenericDao<T> {
    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DaoException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DaoException;


    public T persist(T object) throws DaoException {
        T persistInstance;
        // Добавляем запись
        String sql = getCreateQuery();
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On persist modify more then 1 record:");
            }
            sql = getSelectQuery() + " WHERE id = last_insert_id();";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new DaoException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (SQLException e) {
            throw new DaoException("Create error", e);
        }
        return persistInstance;
    }


    public T getByPK(int key) throws DaoException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoException("Error of getting ", e);
        }
        if (list == null || list.size() == 0) {
            throw new DaoException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new DaoException("Received more than one record.");
        }
        return list.iterator().next();
    }

    public void update(T object) throws DaoException {
        String sql = getUpdateQuery();
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForUpdate(statement, object); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new DaoException("Error of updating", e);
        }
    }

    public void delete(T object) throws DaoException {
        String sql = getDeleteQuery();
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, object.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            throw new DaoException("Error of delete", e);
        }
    }

    public List<T> getAll() throws DaoException {
        List<T> list;
        String sql = getSelectQuery();
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoException("Error of getting all" + e);
        }
        return list;
    }
}
