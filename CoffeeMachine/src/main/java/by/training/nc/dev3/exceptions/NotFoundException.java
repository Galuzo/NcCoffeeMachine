package by.training.nc.dev3.exceptions;

/**
 * Created by Win on 22.03.2017.
 */
public class NotFoundException extends Exception {
    Object element;
    public NotFoundException(String message, Object element)
    {
        super(message);
        this.element=element;
    }

    public Object getElement() {
        return element;
    }
}
