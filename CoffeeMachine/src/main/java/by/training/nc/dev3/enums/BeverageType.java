package by.training.nc.dev3.enums;

/**
 * Created by Win on 19.03.2017.
 */
public enum BeverageType {
    LATTE,TEA;
    public String getBeverageType(){
        switch(this){
            case LATTE:
                return "latte";
            case TEA:
                return "tea";

            default:
                return "Indefined";

        }
    }
}
