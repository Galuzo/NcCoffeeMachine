package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.ContentInBill;
import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.connectionpool.ConnectionPool;
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



    public Map<Content,List<Content>> showResultBill(User user) throws DaoException{
        HashMap<Content, List<Content>>listOfBill = new HashMap<Content, List<Content>>();
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        GenericDao billDao = new BillDaoImpl();
        ContentDaoImpl beverageDao = new BeverageDaoImpl();
        Content beverage=null;
        Bill bill=new Bill();
        double generalCost = 0.0;
        List<Content> listIngredientOfBeverage = new ArrayList<Content>();
        try {
            bill = (Bill) billDao.getByPK(user.getId());
            List<ContentInBill> billWithId = contentInBillDao.getByBill(bill.getId());
            for (ContentInBill i : billWithId) {
                beverage = beverageDao.getByPK(i.getIdBeverage());
                if(listOfBill.get(beverage)!=null)
                {
                    listIngredientOfBeverage = listOfBill.get(beverage);
                    generalCost=putInList(i,listIngredientOfBeverage,generalCost);
                    listOfBill.put(beverage, listIngredientOfBeverage);
                }
                else
                {
                    listIngredientOfBeverage = new ArrayList<Content>();
                    generalCost=putInList(i,listIngredientOfBeverage,generalCost);
                    listOfBill.put(beverage, listIngredientOfBeverage);
                }

            }
            System.out.println("Current Date: " + bill.getDate());
            System.out.println("General cost:: " + bill.getGeneralCost());
        } catch (Exception e) {
            throw new DaoException("The bill is empty");
        }
        finally {
            bill.setDate(new GregorianCalendar().getTime());
            bill.setGeneralCost(generalCost);
            try {
                billDao.update(bill);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        return listOfBill;
    }


    private double putInList(ContentInBill i,List<Content> listIngredientOfBeverage,double generalCost) {
        ContentDaoImpl ingredientDao = new IngredientDaoImpl();
        ContentDaoImpl beverageDao = new BeverageDaoImpl();
        try {
            if (i.getIdIngredient() != 0) {
                Content ingredient = ingredientDao.getByPK(i.getIdIngredient());
                for (int count=0;count<i.getBeverageCount();count++) {
                    listIngredientOfBeverage.add(ingredient);
                    generalCost+=ingredient.getCost();
                    generalCost+=beverageDao.getByPK(i.getIdBeverage()).getCost();
                }
            } else {
                for (int count=0;count<i.getBeverageCount();count++) {
                    listIngredientOfBeverage.add(null);
                    generalCost+=beverageDao.getByPK(i.getIdBeverage()).getCost();
                }
            }
        } catch (DaoException e ) {
            System.out.println(e);
        }
        return generalCost;
    }

    public double getCost(User user)
    {
        BillDaoImpl billDao = new BillDaoImpl();
        Bill bill=null;
        try {
            bill=billDao.getByUser(user.getId());

        } catch (DaoException e) {
            e.printStackTrace();
        }

        return  bill.getGeneralCost();
    }

}
