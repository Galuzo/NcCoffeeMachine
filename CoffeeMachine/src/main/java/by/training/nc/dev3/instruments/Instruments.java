package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.ContentInBill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 20.03.2017.
 */
public class Instruments {




    public static ContentInBill findIngredientInBeverage(List<ContentInBill> contentInBills, int idIngredient) {
        for(ContentInBill contentInBill : contentInBills) {
            if (contentInBill.getIdIngredient() == idIngredient) {
                return contentInBill;
            }
        }
        return null;
    }

   /* public static List<ContentInBill> parseResult(ResultSet resultSet) {
        long instanceId;
        long instanceIdBill;
        long instanceIdBeverage;
        long instanceIdIngredient;
        int instanceBeverageCount;
        List<ContentInBill> list = new ArrayList<ContentInBill>();
        try {
            while (resultSet.next()) {
                instanceId = resultSet.getLong("id");
                instanceIdBill=resultSet.getLong("idBill");
                instanceIdBeverage = resultSet.getLong("idBeverage");
                instanceIdIngredient = resultSet.getLong("idIngredient");
                instanceBeverageCount = resultSet.getInt("beverageCount");
                ContentInBill contentInBill = new ContentInBill(instanceId,instanceIdBill,instanceIdBeverage,instanceIdIngredient,instanceBeverageCount);
                list.add(contentInBill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }*/

    public static int incrementValue(int value,int count) {
       return value+count;
    }
    public static int decrementValue(int value,int count) {
        value = value - count;
        if (value < 0)
        {
            value=0;
        }
        return value;
    }


}
