package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.ContentInBill;
import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.dao.GenericDao;
import by.training.nc.dev3.dao.implementations.BillDaoImpl;
import by.training.nc.dev3.dao.implementations.ContentInBillDaoImpl;
import by.training.nc.dev3.dao.implementations.IngredientDaoImpl;
import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.BillWorkHelper;
import by.training.nc.dev3.instruments.ContentWorkHelper;
import by.training.nc.dev3.instruments.Instruments;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;

/**
 * Created by Win on 21.03.2017.
 */
public class ClientService {

    public ClientService() {
    }

    public void addBeverageInBill(User user, int id) {
        ContentDaoImpl contentDao = ContentWorkHelper.generateContentDao(ContentType.BEVERAGE);
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        try {
            Content beverageInMachine = contentDao.getByPK(id);
            if (beverageInMachine.getCount() > 0) {
                Bill bill = billDao.getByUser(user.getId());
                List<ContentInBill> beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), id);
                if (beverageInBill != null) {
                    ContentInBill emptyBeverage = BillWorkHelper.incrementEmptyBeverage(beverageInBill, 0);
                    int currentValue = beverageInMachine.getCount();
                    beverageInMachine.setCount(Instruments.decrementValue(currentValue, 1));
                    if (emptyBeverage != null) {
                        contentInBillDao.update(emptyBeverage);
                    } else {
                        ContentInBill newContein = new ContentInBill(0, bill.getId(), id, 0, 1);
                        contentInBillDao.persist(newContein);
                    }
                    contentDao.update(beverageInMachine);

                }
            }
        } catch (DaoException e) {
            System.out.println("The element was not found ");
        }
    }


    public void addIngredient(User user, int idBeverage, int idIngredient) {
        ContentDaoImpl contentDao = new IngredientDaoImpl();
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();

        Content ingredientInMachine = ContentWorkHelper.checkRecord(ContentType.INGREDIENT, idIngredient);
        if (ingredientInMachine != null && ingredientInMachine.getCount() > 0) {
            Bill bill = null;
            try {
                bill = billDao.getByUser(user.getId());
                List<ContentInBill> beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), idBeverage);
                ContentInBill importantBeverages = BillWorkHelper.getBeverageWithIngredient(beverageInBill, idIngredient);
                ingredientInMachine.setCount(Instruments.decrementValue(ingredientInMachine.getCount(), 1));
                if (importantBeverages != null) {
                    importantBeverages.setBeverageCount(Instruments.incrementValue(importantBeverages.getBeverageCount(), 1));
                } else {
                    importantBeverages = BillWorkHelper.getBeverageWithIngredient(beverageInBill, 0);
                    importantBeverages.setBeverageCount(Instruments.decrementValue(importantBeverages.getBeverageCount(), 1));
                    ContentInBill newBeverage = new ContentInBill(0, bill.getId(), idBeverage, idIngredient, 1);
                    contentInBillDao.persist(newBeverage);

                }
                contentInBillDao.update(importantBeverages);
                contentDao.update(ingredientInMachine);

            } catch (DaoException e) {
                System.out.println("The element was not found ");
            }
        } else {
            System.out.println("The ingredient is absent");
        }

    }


    public void removeBeverageFromBill(User user, int idBeverage) {
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        ContentDaoImpl beverageDao = ContentWorkHelper.generateContentDao(ContentType.BEVERAGE);
        ContentDaoImpl ingredientDao = ContentWorkHelper.generateContentDao(ContentType.INGREDIENT);

        try {
            Bill bill = billDao.getByUser(user.getId());
            ContentInBill beverageInBill = contentInBillDao.getByPK(idBeverage);
            if(beverageInBill.getIdBill()==bill.getId()) {
                Content commonBeverage = beverageDao.getByPK(beverageInBill.getIdBeverage());
                Content commonIngredient = ingredientDao.getByPK(beverageInBill.getIdIngredient());
                commonBeverage.setCount(Instruments.incrementValue(commonBeverage.getCount(), beverageInBill.getBeverageCount()));
                commonIngredient.setCount(Instruments.incrementValue(commonIngredient.getCount(), beverageInBill.getBeverageCount()));
                contentInBillDao.delete(beverageInBill);
                ingredientDao.update(commonIngredient);
                beverageDao.update(commonBeverage);
            }
            else {

                System.out.println("The bill doesn't have this beverage");
            }

        } catch (DaoException e) {
            System.out.println("Error remove beverage" + e);
        }


    }

    public void removeIngredientFromBill(User user,int idBeverage,int idIngredient) {
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        ContentDaoImpl ingredientDao = ContentWorkHelper.generateContentDao(ContentType.INGREDIENT);

        try {
            Bill bill = billDao.getByUser(user.getId());
            ContentInBill beverageInBill = contentInBillDao.getByPK(idBeverage);
            if(beverageInBill.getIdBill()==bill.getId()) {
                if (beverageInBill.getIdIngredient() == idIngredient) {
                    Content commonIngredient = ingredientDao.getByPK(idIngredient);
                    commonIngredient.setCount(Instruments.incrementValue(commonIngredient.getCount(),1));
                    beverageInBill.setBeverageCount(Instruments.decrementValue(beverageInBill.getBeverageCount(),1));
                    if(beverageInBill.getBeverageCount()>0)
                    {
                        contentInBillDao.update(beverageInBill);
                    }
                    else {
                        contentInBillDao.delete(beverageInBill);
                    }
                    ingredientDao.update(commonIngredient);

                } else {
                    System.out.println("The beverage doesn't have this ingredient");

                }
            }
            else{

                    System.out.println("The bill doesn't have this beverage");
                }

        } catch (DaoException e) {
            System.out.println("Error remove beverage" + e);
        }

    }
}


