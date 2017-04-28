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
import by.training.nc.dev3.exceptions.NotFoundException;
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

    public void addBeverageInBill(User user, int id) throws DaoException {
        ContentDaoImpl contentDao = ContentWorkHelper.generateContentDao(ContentType.BEVERAGE);
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        Content beverageInMachine = null;
        Bill bill = null;
        try {
            beverageInMachine = contentDao.getByPK(id);
            if (beverageInMachine.getCount() > 0) {
                bill = billDao.getByUser(user.getId());
                beverageInMachine.setCount(Instruments.decrementValue(beverageInMachine.getCount(), 1));
                List<ContentInBill> beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), id);
                ContentInBill emptyBeverage = BillWorkHelper.incrementEmptyBeverage(beverageInBill, 0);
                if (emptyBeverage != null) {
                    contentInBillDao.update(emptyBeverage);
                } else {
                    ContentInBill newContein = new ContentInBill(0, bill.getId(), id, 0, 1);
                    contentInBillDao.persist(newContein);
                }
            } else {
                throw new DaoException("The beverage count is less then 0");
            }

        } catch (DaoException e) {
            throw new DaoException(e);
        } catch (NotFoundException e) {
            ContentInBill newContein = new ContentInBill(0, bill.getId(), id, 0, 1);
            contentInBillDao.persist(newContein);
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            contentDao.update(beverageInMachine);
        }
    }


    public void addIngredient(User user, int idBeverage, int idIngredient) throws DaoException {
        ContentDaoImpl contentDao = new IngredientDaoImpl();
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        Content ingredientInMachine = ContentWorkHelper.checkRecord(ContentType.INGREDIENT, idIngredient);
        if (ingredientInMachine != null && ingredientInMachine.getCount() > 0) {
            Bill bill = null;
            try {
                bill = billDao.getByUser(user.getId());
                List<ContentInBill> beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), idBeverage);
                ContentInBill beverageToInc = BillWorkHelper.getBeverageWithIngredient(beverageInBill, idIngredient);
                ContentInBill emptyBeverages = BillWorkHelper.getBeverageWithIngredient(beverageInBill, 0);
                ingredientInMachine.setCount(Instruments.decrementValue(ingredientInMachine.getCount(), 1));
                if (emptyBeverages != null && emptyBeverages.getBeverageCount() > 0) {
                    if (beverageToInc != null) {
                        beverageToInc.setBeverageCount(Instruments.incrementValue(beverageToInc.getBeverageCount(), 1));
                        emptyBeverages.setBeverageCount(Instruments.decrementValue(emptyBeverages.getBeverageCount(), 1));
                        contentInBillDao.update(beverageToInc);
                    } else {
                        ContentInBill newBeverage = new ContentInBill(0, bill.getId(), idBeverage, idIngredient, 1);
                        contentInBillDao.persist(newBeverage);
                        emptyBeverages.setBeverageCount(Instruments.decrementValue(emptyBeverages.getBeverageCount(), 1));
                    }
                    if (emptyBeverages.getBeverageCount() > 0) {
                        contentInBillDao.update(emptyBeverages);
                    } else {
                        contentInBillDao.delete(emptyBeverages);
                    }
                    contentDao.update(ingredientInMachine);
                } else {
                    throw new DaoException("You should add empty beverage to add ingredient to it");
                }
            } catch (NotFoundException e) {
                throw new DaoException("The beverage not found in bill ");
            } catch (DaoException e) {
                throw new DaoException(e);
            } catch (Exception e) {
                throw new DaoException(e);
            }
        } else {
            throw new DaoException("The beverage not found in Machine");
        }

    }


    public void removeBeverageFromBill(User user, int idBeverage,int idIngredient) throws DaoException{
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        ContentDaoImpl ingredientDao = new IngredientDaoImpl();
        ContentDaoImpl beverageDao = new BeverageDaoImpl();
        Bill bill = billDao.getByUser(user.getId());
        List<ContentInBill> beverageInBill = null;
        try {
            Content beverage = beverageDao.getByPK(idBeverage);
            if(idIngredient!=0)
            {
                Content ingredient = ingredientDao.getByPK(idIngredient);
                ingredient.setCount(Instruments.incrementValue(ingredient.getCount(), 1));
                ingredientDao.update(ingredient);
            }
            beverage.setCount(Instruments.incrementValue(beverage.getCount(),1));
            beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), idBeverage);
            ContentInBill removedBeverageWithIngredient = BillWorkHelper.getBeverageWithIngredient(beverageInBill, idIngredient);
            removedBeverageWithIngredient.setBeverageCount(Instruments.decrementValue(removedBeverageWithIngredient.getBeverageCount(), 1));
            if(removedBeverageWithIngredient.getBeverageCount()==0)
            {
                contentInBillDao.delete(removedBeverageWithIngredient);
            }
            else
            {
                contentInBillDao.update(removedBeverageWithIngredient);
            }

            beverageDao.update(beverage);

        } catch (NotFoundException e) {
            throw new DaoException("The beverage not found in bill ");
        }
    }

    public void removeIngredientFromBill(User user, int idBeverage, int idIngredient) throws DaoException {
        ContentDaoImpl contentDao = new IngredientDaoImpl();
        ContentInBillDaoImpl contentInBillDao = new ContentInBillDaoImpl();
        BillDaoImpl billDao = new BillDaoImpl();
        Content ingredientInMachine = contentDao.getByPK(idIngredient);
        Bill bill = null;
        try {
            bill = billDao.getByUser(user.getId());
            List<ContentInBill> beverageInBill = contentInBillDao.getByBillAndBeverage(bill.getId(), idBeverage);
            ingredientInMachine.setCount(Instruments.incrementValue(ingredientInMachine.getCount(),1));
            ContentInBill removedBeverageWithIngredient = BillWorkHelper.getBeverageWithIngredient(beverageInBill, idIngredient);
            ContentInBill emptyBeverages = BillWorkHelper.getBeverageWithIngredient(beverageInBill, 0);
            removedBeverageWithIngredient.setBeverageCount(Instruments.decrementValue(removedBeverageWithIngredient.getBeverageCount(), 1));
            if (emptyBeverages != null) {
                emptyBeverages.setBeverageCount(Instruments.incrementValue(emptyBeverages.getBeverageCount(), 1));
                contentInBillDao.update(emptyBeverages);

            } else {
                ContentInBill beverage = new ContentInBill(0, bill.getId(), idBeverage, 0, 1);
                contentInBillDao.persist(beverage);
            }
            if (removedBeverageWithIngredient.getBeverageCount() == 0) {
                contentInBillDao.delete(removedBeverageWithIngredient);
            }
            else
            {
                contentInBillDao.update(removedBeverageWithIngredient);
            }
            contentDao.update(ingredientInMachine);
        } catch (NotFoundException e) {
            throw new DaoException("The beverage not found in bill ");
        } catch (DaoException e) {
            throw new DaoException(e);
        }
    }
}


