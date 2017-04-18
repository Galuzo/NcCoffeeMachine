package by.training.nc.dev3.dao.implementations;

import by.training.nc.dev3.beans.ContentInBill;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.dao.implementations.commons.GenericDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;

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
public class UserDaoImpl extends GenericDaoImpl<User> {
    public String getSelectQuery() {
        return "SELECT * FROM users";
    }

    public String getCreateQuery() {
        return "INSERT INTO users (login,password,idRole) values(?,?,?)";
    }

    public String getUpdateQuery() {
        return "UPDATE users SET login=? , password=? , idRole=? WHERE idUser=?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM users WHERE idUser=?";
    }

    protected List<User> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("idUser"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setIdRoles(rs.getLong("IdRole"));
                result.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Error parsing result",e);
        }
        return result;
    }

    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws DaoException {
        try {
            statement.setString(1,object.getLogin());
            statement.setString(2,object.getPassword());
            statement.setLong(3,object.getIdRoles());
        } catch (SQLException e) {
            throw new DaoException("Error creating prepare statement for insert",e);
        }
    }

    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws DaoException {
        try{
            statement.setString(1,object.getLogin());
            statement.setString(2,object.getPassword());
            statement.setLong(3,object.getIdRoles());
            statement.setLong(4,object.getId());
        } catch (SQLException e) {
            throw new DaoException("Error creating prepare statement for uprate",e);
        }
    }

    public User getByName(String login)throws DaoException{
        User user=null;
        try {
            Connection connection= ConnectionPool.getConnection();
            String sql = "SELECT * FROM users WHERE login=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getInt("idUser"),resultSet.getString("login"), resultSet.getString("password"), resultSet.getInt("idRole"));
            }
        } catch (SQLException e ) {
            throw new DaoException("User not found", e);
        }
        return user;
    }


}
