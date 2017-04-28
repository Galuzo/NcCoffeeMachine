package by.training.nc.dev3.exceptions;

/**
 * Created by Win on 22.03.2017.
 */
public class NotFoundException extends Exception {
    public NotFoundException(String message, Throwable e )
    {
        super(message,e);

    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable e) {
        super(e);
    }
}
