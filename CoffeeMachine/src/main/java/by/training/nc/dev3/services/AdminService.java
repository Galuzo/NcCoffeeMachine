package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.Content;

import by.training.nc.dev3.dao.GenericDao;
import by.training.nc.dev3.dao.implementations.BeverageDaoImpl;
import by.training.nc.dev3.dao.implementations.IngredientDaoImpl;
import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.exceptions.NotFoundException;
import by.training.nc.dev3.instruments.ContentWorkHelper;
import by.training.nc.dev3.instruments.Instruments;

/**
 * Created by Win on 21.03.2017.
 */
public class AdminService {
   private final int LIMIT=100;

    public void addExistContent(ContentType contentType,int id, int count) {
        GenericDao genericDao = ContentWorkHelper.generateContentDao(contentType);
        Content content = ContentWorkHelper.checkRecord(contentType, id);
        if (content != null && count>0) {
            int oldValue = content.getCount();
            int valueForAdd = ContentWorkHelper.checkLimit(oldValue, count, LIMIT);
            if (valueForAdd > 0) {
                content.setCount(Instruments.incrementValue(oldValue, valueForAdd));
                try {
                    genericDao.update(content);
                    System.out.println("You added " +valueForAdd+" "+ content.getTitle());
                } catch (DaoException e) {
                    System.out.println("Error of update " + content);
                }
            } else
                System.out.println("The limit was reached");
        } else {
            System.out.println("The element was not found or count<0");
        }
    }

    public void addNewContent(ContentType contentType,String title,double cost,int count) {
        ContentDaoImpl genericDao = ContentWorkHelper.generateContentDao(contentType);
        Content content = ContentWorkHelper.checkRecord(contentType, title);
        if (content == null) {
            content = new Content(0, title, cost, count);
            try {
                genericDao.persist(content);
            } catch (DaoException e) {
                System.out.println("Error creating " + title);
            }
        } else {
            System.out.println("The " + title + " is already consists");
        }

    }
}
