package by.training.nc.dev3.beans;

/**
 * Created by Win on 12.04.2017.
 */
public class ContentInBill extends Entity{
    private int idBill;
    private int idBeverage;
    private int idIngredient;
    private int beverageCount;

    public ContentInBill(){}
    public ContentInBill(int id, int idBill, int idBeverage, int idIngredient, int beverageCount) {
        super(id);
        this.idBill = idBill;
        this.idBeverage = idBeverage;
        this.idIngredient = idIngredient;
        this.beverageCount = beverageCount;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdBeverage() {
        return idBeverage;
    }

    public void setIdBeverage(int idBeverage) {
        this.idBeverage = idBeverage;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getBeverageCount() {
        return beverageCount;
    }

    public void setBeverageCount(int beverageCount) {
        this.beverageCount = beverageCount;
    }
}
