package by.training.nc.dev3.dao.implementations;

import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.ContentInBill;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.dao.implementations.commons.GenericDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.exceptions.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Win on 14.04.2017.
 */
public class ContentInBillDaoImpl extends GenericDaoImpl<ContentInBill> {
    public String getSelectQuery() {
        return "SELECT * FROM contentinbill";
    }

    public String getCreateQuery() {
        return "INSERT INTO contentinbill (idBill,idBeverage,idIngredient,beverageCount) values(?,?,?,?)";
    }

    public String getUpdateQuery() {
        return "UPDATE contentinbill SET idBill=? , idBeverage=? , idIngredient=? , beverageCount=? WHERE id=?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM  contentinbill WHERE id=?";
    }

    protected List<ContentInBill> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<ContentInBill> result = new LinkedList<ContentInBill>();
        try {
            while (rs.next()) {
                ContentInBill contentInBill = new ContentInBill();
                contentInBill.setId(rs.getInt("id"));
                contentInBill.setIdBill(rs.getInt("idBill"));
                contentInBill.setIdBeverage(rs.getInt("idBeverage"));
                contentInBill.setIdIngredient(rs.getInt("idIngredient"));
                contentInBill.setBeverageCount(rs.getInt("beverageCount"));
                result.add(contentInBill);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    protected void prepareStatementForInsert(PreparedStatement statement, ContentInBill object) throws DaoException {
        try {
            statement.setLong(1,object.getIdBill());
            statement.setDouble(2,object.getIdBeverage());
            statement.setObject(3,object.getIdIngredient());
            statement.setObject(4,object.getBeverageCount());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    protected void prepareStatementForUpdate(PreparedStatement statement, ContentInBill object) throws DaoException {
        try{
            statement.setLong(1,object.getIdBill());
            statement.setDouble(2,object.getIdBeverage());
            statement.setObject(3,object.getIdIngredient());
            statement.setLong(4,object.getBeverageCount());
            statement.setLong(5,object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<ContentInBill> getByBillAndBeverage(int idBill,int idBeverage)throws NotFoundException{
        List<ContentInBill> list = new ArrayList<ContentInBill>();
        ContentInBill beverage=null;
        Connection connection=null;
        try {
             connection= ConnectionPool.getConnection();
            String sql = "SELECT * FROM contentinbill WHERE idBill=? AND idBeverage=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idBill);
            statement.setInt(2,idBeverage);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst())
            {
                while (resultSet.next()) {
                    beverage = new ContentInBill(resultSet.getInt("id"), resultSet.getInt("idBill"), resultSet.getInt("idBeverage"), resultSet.getInt("idIngredient"), resultSet.getInt("beverageCount"));
                    list.add(beverage);
                }
            }
            else
            {
                throw new NotFoundException("Record with idBill = " + idBill + " and with IdBeverage="+idBeverage+ " not found.");

            }
        } catch (Exception e ) {
            throw new NotFoundException(e);
        }
        finally {
            ConnectionPool.closeConnection(connection);
        }
        return list;
    }

    public List<ContentInBill> getByBill(int idBill)throws DaoException{
        List<ContentInBill> list = new ArrayList<ContentInBill>();
        ContentInBill beverage=null;
        Connection connection = null;
        try {
             connection= ConnectionPool.getConnection();
            String sql = "SELECT * FROM contentinbill WHERE idBill=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idBill);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    beverage = new ContentInBill(resultSet.getInt("id"), resultSet.getInt("idBill"), resultSet.getInt("idBeverage"), resultSet.getInt("idIngredient"), resultSet.getInt("beverageCount"));
                    list.add(beverage);
                }
            }
            else
            {
                throw new DaoException("Record with idBill = " + idBill + " not found.");
            }
        } catch (Exception e ) {
            throw new DaoException( e);
        }
        finally {
            ConnectionPool.closeConnection(connection);
        }
        return list;
    }
}
