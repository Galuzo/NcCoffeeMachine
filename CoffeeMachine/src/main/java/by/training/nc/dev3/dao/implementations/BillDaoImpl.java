package by.training.nc.dev3.dao.implementations;

import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.dao.implementations.commons.GenericDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Win on 14.04.2017.
 */
public class BillDaoImpl extends GenericDaoImpl<Bill> {
    public String getSelectQuery() {
        return "SELECT * FROM bills ";
    }

    public String getCreateQuery() {
        return "INSERT INTO bills (idUser,generalCost,date) values(?,?,?)";
    }

    public String getUpdateQuery() {
        return "UPDATE bills SET  idUser=? , generalCost=? , date=? WHERE id=?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM bills WHERE id= ?";
    }

    protected List<Bill> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<Bill> result = new LinkedList<Bill>();
        try {
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setIdUsers(rs.getLong("idUser"));
                bill.setGeneralCost(rs.getDouble("generalCost"));
                bill.setDate(rs.getDate("date"));
                result.add(bill);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    protected void prepareStatementForInsert(PreparedStatement statement, Bill object) throws DaoException {
        try {
            statement.setLong(1,object.getIdUsers());
            statement.setDouble(2,object.getGeneralCost());
            statement.setObject(3,object.getDate());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    protected void prepareStatementForUpdate(PreparedStatement statement, Bill object) throws DaoException {
        try{
            statement.setLong(1,object.getIdUsers());
            statement.setDouble(2,object.getGeneralCost());
            statement.setObject(3,object.getDate());
            statement.setLong(4,object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Bill getByUser(int id)throws DaoException{
        Bill bill=null;
        Connection connection = null;
        try {
             connection= ConnectionPool.getConnection();
            String sql="SELECT * FROM bills WHERE idUser=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                bill = new Bill(resultSet.getInt("id"), resultSet.getInt("idUser"), resultSet.getDouble("generalCost"), resultSet.getDate("date"));
            }
            else
            {
                throw new DaoException("Record with PK = " + id + " not found.");
            }
        } catch (Exception e ) {
            throw new DaoException(e);
        }
        finally {
            ConnectionPool.closeConnection(connection);
        }
        return bill;
    }
}
