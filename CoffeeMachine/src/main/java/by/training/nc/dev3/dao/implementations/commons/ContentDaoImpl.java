package by.training.nc.dev3.dao.implementations.commons;

import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Win on 14.04.2017.
 */
public abstract class ContentDaoImpl extends GenericDaoImpl<Content> {
    protected abstract String getSelectByTitle();
    protected void prepareStatementForInsert(PreparedStatement statement, Content object) throws DaoException {
        try {
            statement.setString(1,object.getTitle());
            statement.setDouble(2,object.getCost());
            statement.setInt(3,object.getCount());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    protected void prepareStatementForUpdate(PreparedStatement statement, Content object) throws DaoException {
        try{
            statement.setString(1,object.getTitle());
            statement.setDouble(2,object.getCost());
            statement.setInt(3,object.getCount());
            statement.setLong(4,object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }
    protected List<Content> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<Content> result = new LinkedList<Content>();
        try {
            while (rs.next()) {
                Content ingredient = new Content();
                ingredient.setId(rs.getInt("id"));
                ingredient.setTitle(rs.getString("title"));
                ingredient.setCost(rs.getDouble("cost"));
                ingredient.setCount(rs.getInt("count"));
                result.add(ingredient);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    public  Content getByTitle(String title)throws DaoException{
        Content beverage=null;
        Connection connection=null;
        try {
             connection= ConnectionPool.getConnection();
            String sql=getSelectByTitle();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                 beverage = new Content(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDouble("cost"), resultSet.getInt("count"));
            }
            else
            {
                throw new DaoException("Record with title = " + title + " not found.");
            }
        } catch (Exception e ) {
            throw new DaoException(e);
        }
        finally {
            ConnectionPool.closeConnection(connection);
        }
        return beverage;
    }
}
