package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.ContentInBill;
import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.dao.GenericDao;
import by.training.nc.dev3.dao.implementations.BeverageDaoImpl;
import by.training.nc.dev3.dao.implementations.BillDaoImpl;

import by.training.nc.dev3.dao.implementations.ContentInBillDaoImpl;
import by.training.nc.dev3.dao.implementations.IngredientDaoImpl;
import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.ContentWorkHelper;

import java.util.*;

/**
 * Created by Win on 21.03.2017.
 */
public class BillService {

    public void showResultBill(User user) {
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        GenericDao billDao = new BillDaoImpl();
        ContentDaoImpl ingredientDao = new IngredientDaoImpl();
        ContentDaoImpl beverageDao = new BeverageDaoImpl();
        double generalCost = 0;
        try {
            Bill bill = (Bill) billDao.getByPK(user.getId());
            List<ContentInBill> billWithId = contentInBillDao.getByBill(bill.getId());
            for (ContentInBill i : billWithId) {
                Content beverage = beverageDao.getByPK(i.getIdBeverage());
                if (i.getIdIngredient() != 0) {
                    Content ingredient = ingredientDao.getByPK(i.getIdIngredient());
                    System.out.println(i.getId() + ". " + beverage.getTitle() + " cost:" + beverage.getCost() + " {ingredient:" + ingredient.getTitle() + " cost:" + ingredient.getCost() + "}" + " count:" + i.getBeverageCount());
                    generalCost += beverage.getCost() * i.getBeverageCount();
                    generalCost += ingredient.getCost() * i.getBeverageCount();
                } else {

                    System.out.println(i.getId() + ". " + beverage.getTitle() + " cost:" + beverage.getCost() + " count:" + i.getBeverageCount());
                    generalCost += beverage.getCost() * i.getBeverageCount();
                }

            }
            bill.setDate(new GregorianCalendar().getTime());
            bill.setGeneralCost(generalCost);
            billDao.update(bill);
            System.out.println("Current Date: " + bill.getDate());
            System.out.println("General cost:: " + bill.getGeneralCost());
        } catch (DaoException e) {
            System.out.println("Error showResult" + e);
        }

    }
}
