package by.training.nc.dev3.exceptions;

/**
 * Created by Win on 22.03.2017.
 */
public class IncorrectValue extends Exception {
    Object element;
    public IncorrectValue(String message,Object element) {
        super(message);
        this.element=element;
    }

    public Object getElement() {
        return element;
    }
}
