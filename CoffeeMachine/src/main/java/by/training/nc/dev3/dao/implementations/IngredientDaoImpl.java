package by.training.nc.dev3.dao.implementations;

import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;

/**
 * Created by Win on 14.04.2017.
 */
public class IngredientDaoImpl extends ContentDaoImpl {
    public String getSelectQuery() {
        return "SELECT * FROM ingredients";
    }

    public String getCreateQuery() {
        return "INSERT INTO ingredients (title,cost,count) values(?,?,?)";
    }

    public String getUpdateQuery() {
        return "UPDATE ingredients SET title=?,cost=?,count=? WHERE id=?";
    }

    public String getDeleteQuery() {
        return "DELETE FROM ingredients WHERE id= ?";
    }


    protected String getSelectByTitle() {
        return "SELECT * FROM ingredients WHERE title=?";
    }
}
