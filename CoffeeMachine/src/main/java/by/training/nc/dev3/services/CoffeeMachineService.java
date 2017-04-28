package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.ContentWorkHelper;

import java.util.List;

/**
 * Created by Win on 21.03.2017.
 */
public class CoffeeMachineService {

    public void showAssortiment()
    {
        System.out.println("***************Assortiment*****************");
       // showBeveragesInMachine();
       // showIngredientsInMachine();

    }

    public List<Content> getBeveragesInMachine()
    {
        System.out.println("Beverages: ");
        ContentDaoImpl contentDao = ContentWorkHelper.generateContentDao(ContentType.BEVERAGE);
        List<Content> beverages = null;
        try {
            beverages = contentDao.getAll();
        } catch (DaoException e) {
            System.out.println("Not found beverages");
        }
        /*for (Content beverage : beverages) {
            System.out.println("\t"+ beverage.getId()+ ". " + beverage.getTitle()+". Cost:"+ beverage.getCost()+" Count:"+ beverage.getCount());
        }*/
        return beverages;
    }

    public List<Content> getIngredientsInMachine()
    {
        ContentDaoImpl contentDao = ContentWorkHelper.generateContentDao(ContentType.INGREDIENT);
        System.out.println("Ingredients: ");
        List<Content> ingredients = null;
        try {
            ingredients = contentDao.getAll();
        } catch (DaoException e) {
            System.out.println("Not found ingredients");
        }
        return ingredients;
    }

}
