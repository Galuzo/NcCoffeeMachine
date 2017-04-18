package by.training.nc.dev3.dao.implementations;

import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;

/**
 * Created by Win on 14.04.2017.
 */
public class BeverageDaoImpl extends ContentDaoImpl {
    public String getSelectQuery() {
        return "SELECT * FROM beverages";
    }

    public String getCreateQuery() {
        return "INSERT INTO beverages (title,cost,count) values(?,?,?)";
    }

    public String getUpdateQuery() {
        return "UPDATE beverages SET title=?,cost=?,count=? WHERE id=?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM beverages WHERE id= ?";
    }

    protected String getSelectByTitle() {
        return "SELECT * FROM beverages WHERE title=?";
    }
}
