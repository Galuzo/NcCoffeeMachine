package by.training.nc.dev3.enums;

/**
 * Created by Win on 19.03.2017.
 */
public enum IngredientType {
    CHOCOLATE,MILK;

    public String getIngredientType(){
        switch(this){
            case CHOCOLATE:
                return "chocolate";
            case MILK:
                return "milk";

            default:
                return "Indefined";
        }
    }
}
