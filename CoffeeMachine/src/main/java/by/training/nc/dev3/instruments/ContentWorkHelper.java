package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.dao.GenericDao;
import by.training.nc.dev3.dao.implementations.BeverageDaoImpl;
import by.training.nc.dev3.dao.implementations.IngredientDaoImpl;
import by.training.nc.dev3.dao.implementations.commons.ContentDaoImpl;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.exceptions.DaoException;

/**
 * Created by Win on 14.04.2017.
 */
public class ContentWorkHelper {

    public static ContentDaoImpl generateContentDao(ContentType contentType)
    {
        ContentDaoImpl genericDao=null;
        switch (contentType) {
            case BEVERAGE:
                genericDao=new BeverageDaoImpl();
                break;
            case INGREDIENT:
                genericDao = new IngredientDaoImpl();
                break;
        }
        return genericDao;
    }
    public static Content checkRecord(ContentType contentType, int id)
    {
        GenericDao genericDao = generateContentDao(contentType);
        Content content;
        try {
            content=(Content)genericDao.getByPK(id);
        } catch (DaoException e) {
            return null;
        }
        return content;
    }

    public static Content checkRecord(ContentType contentType, String title)
    {
        ContentDaoImpl genericDao = generateContentDao(contentType);
        Content content;
        try {
            content=(Content)genericDao.getByTitle(title);
        } catch (DaoException e) {
            return null;
        }
        return content;
    }

    public static int checkLimit(int currentCount,int count,int limit)
    {
        int result=0;
        if(currentCount<limit) {
            int difference = limit - currentCount;
            if (count > difference) {
                result= difference;
            } else {
                result= count;
            }
        }
        return result;
    }
}
