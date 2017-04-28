package by.training.nc.dev3.exceptions;

/**
 * Created by Win on 14.04.2017.
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable e) {
        super(e);
    }

    public DaoException(String message, Throwable e) {
        super(message,e);
    }
}
