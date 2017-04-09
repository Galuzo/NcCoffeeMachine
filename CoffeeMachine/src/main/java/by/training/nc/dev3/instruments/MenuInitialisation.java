package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.content.AbstractIngredient;
import by.training.nc.dev3.beans.machines.CoffeeMachine;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.services.AdminService;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.ClientService;
import by.training.nc.dev3.services.CoffeeMachineService;

import java.io.File;
import java.io.InvalidObjectException;

/**
 * Created by Win on 25.03.2017.
 */
public class MenuInitialisation {
    static private Administrator administrator;
    static private Client client;
    static private CoffeeMachine coffeeMachine;
    static private ClientService clientService;
    static private CoffeeMachineService coffeeMachineService;
    static private AdminService adminService;
    static private BillService billService;
    static public void showMenu()
    {
        int input;
        while(true)
        {
            System.out.println("********************Menu*************************");
            System.out.println("Select your role:");
            System.out.println("\t1.Administrator");
            System.out.println("\t2.Client");
            System.out.println("\t3.Exit");
            switch (InputData.inputNumber())
            {
                case 1:
                    //Administrator
                    administrator = new Administrator(coffeeMachine);
                    do{
                    System.out.println("********************Possibility*************************");
                    System.out.println("\t1.Add beverage in CoffeeMachine");
                    System.out.println("\t2.Add ingredient in CoffeeMachine");
                    System.out.println("\t3.Show assortiment");
                    System.out.println("\t4.Back in the last menu");

                        switch (input=InputData.inputNumber()) {
                            case 1:
                                do{
                                    System.out.println("********************Beverages*************************");
                                    System.out.println("Select beverage");
                                    System.out.println("\t1.Latte");
                                    System.out.println("\t2.Tea");
                                    System.out.println("\t3.Back in the last menu");
                                    switch (input=InputData.inputNumber()) {

                                        case 1:
                                            System.out.println("How much do you want to add?");
                                            int count = InputData.inputNumber();
                                            if(count!=0) {
                                                adminService.addBeverage(administrator, BeverageType.LATTE, count);
                                            }
                                            else
                                            {
                                                System.out.println("you are trying to add zero");
                                                FileWorker.writeLogger("you are trying to add zero");
                                                continue;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("How much do you want to add?");
                                            count = InputData.inputNumber();
                                            if(count!=0) {
                                                adminService.addBeverage(administrator, BeverageType.TEA, count);
                                            }
                                            else
                                            {
                                                System.out.println("you are trying to add zero");
                                                FileWorker.writeLogger("you are trying to add zero");
                                                continue;

                                            }
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Incorrect input");
                                            FileWorker.writeLogger("Incorrect input");
                                            continue;

                                    }
                                    break;
                                }while(input!=3);
                                break;
                            case 2:
                                do
                                {
                                    System.out.println("********************Ingredients*************************");
                                    System.out.println("Which ingredient do you want to add?");
                                    System.out.println("\t1.Milk");
                                    System.out.println("\t2.Chocolate");
                                    System.out.println("\t3.Back in the last menu");
                                    switch (input=InputData.inputNumber())
                                    {
                                        case 1:
                                            System.out.println("How much do you want to add?");
                                            int count = InputData.inputNumber();
                                            if(count!=0) {
                                                adminService.addIngredient(administrator, IngredientType.MILK, count);

                                            }
                                            else
                                            {
                                                System.out.println("you are trying to add zero");
                                                FileWorker.writeLogger("you are trying to add zero");
                                                continue;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("How much do you want to add?");
                                            count = InputData.inputNumber();
                                            if(count!=0) {
                                                adminService.addIngredient(administrator, IngredientType.CHOCOLATE, count);
                                            }
                                            else
                                            {
                                                System.out.println("you are trying to add zero");
                                                FileWorker.writeLogger("you are trying to add zero");
                                                continue;
                                            }
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Incorrect input");
                                            FileWorker.writeLogger("Incorrect input");
                                            continue;
                                    }
                                    break;
                                }while (input!=3);
                                break;

                            case 3:
                                coffeeMachineService.showAssortiment(coffeeMachine);
                                break;

                            case 4 :
                                break;
                            default:
                                System.out.println("Incorrect input");
                                FileWorker.writeLogger("Incorrect input");
                                break;
                        }
                    }while (input!=4);
                    break;


                //Client
                case 2:

                    do{
                        System.out.println("********************Possibility*************************");
                        System.out.println("\t1.Add beverage in the bill");
                        System.out.println("\t2.Add ingredient in the bill");
                        System.out.println("\t3.remove beverage from the bill");
                        System.out.println("\t4.remove ingredient from the beverage");
                        System.out.println("\t5.Show assortiment");
                        System.out.println("\t6.Show Bill");
                        System.out.println("\t7.Back in the last menu");
                        switch (input=InputData.inputNumber())
                        {
                            case 1:
                               do
                               {
                                   System.out.println("********************Beverages*************************");
                                   System.out.println("Select beverage");
                                   System.out.println("\t1.Latte");
                                   System.out.println("\t2.Tea");
                                   System.out.println("\t3.Back in the last menu");

                                   switch (input=InputData.inputNumber())
                                   {
                                       case 1:
                                           clientService.addBeverageInBill(client,BeverageType.LATTE);
                                           System.out.println(BeverageType.LATTE+ " was added");
                                           break;
                                       case 2:
                                           clientService.addBeverageInBill(client,BeverageType.TEA);
                                           System.out.println(BeverageType.TEA+ " was added");
                                           break;
                                       case 3:
                                           break;
                                           default:
                                               System.out.println("Incorrect input");
                                               FileWorker.writeLogger("Incorrect input");
                                               continue;
                                   }
                                   break;
                               }while (input!=3);
                               break;
                            case 2:
                                do {
                                    System.out.println("********************Beverages*************************");
                                    billService.showResultBill(client);
                                    if(client.getBill().getBeverages().size()>0) {
                                        System.out.println("To which beverage from you bill do you want to add ingredient?");
                                        System.out.println("Enter '0' to back in the last menu");
                                        int countOfBeverages = client.getBill().getBeverages().size();
                                        int numberOfBeverage = InputData.inputNumber();
                                        input=numberOfBeverage;
                                        if(input!=0) {
                                                if (numberOfBeverage > 0 && numberOfBeverage <= countOfBeverages) {
                                                    do {
                                                    System.out.println("********************Ingredients*************************");
                                                    System.out.println("Which ingredient do you want to add?");
                                                    System.out.println("\t1.Milk");
                                                    System.out.println("\t2.Chocolate");
                                                    System.out.println("\t3.Back in the last menu");
                                                    switch (input=InputData.inputNumber()) {
                                                        case 1:
                                                            if (clientService.addIngredient(client, numberOfBeverage, IngredientType.MILK)) {
                                                                System.out.println(IngredientType.MILK + " was added");
                                                            }
                                                            break;
                                                        case 2:
                                                            if (clientService.addIngredient(client, numberOfBeverage, IngredientType.CHOCOLATE)) {
                                                                System.out.println(IngredientType.CHOCOLATE + " was added");
                                                            }
                                                            break;
                                                        case 3:
                                                            break;
                                                        default:
                                                            System.out.println("Incorrect input");
                                                            FileWorker.writeLogger("Incorrect input");
                                                            continue;


                                                    }
                                                    }while (input!=3);
                                                } else {
                                                    System.out.println("Incorrect number");
                                                    FileWorker.writeLogger("Incorrect number");
                                                    continue;
                                                }

                                        }
                                    }
                                    break;
                                }while (input!=0);
                                break;
                            case 3:
                                System.out.println("********************Beverages*************************");
                                if(client.getBill().getBeverages().size()>0) {
                                        int countOfBeverages = client.getBill().getBeverages().size();
                                        if (countOfBeverages > 0) {
                                            do {
                                                billService.showResultBill(client);
                                                System.out.println("Which beverage do you want to remove?");
                                                System.out.println("Enter '0' to back in the last menu");
                                                int numberOfBeverage = InputData.inputNumber();
                                                input=numberOfBeverage;
                                                if(input!=0) {
                                                    if (numberOfBeverage > 0 && numberOfBeverage <= countOfBeverages) {
                                                        clientService.removeBeverageFromBill(client, numberOfBeverage);
                                                        System.out.println("Beverage was remove");
                                                        break;

                                                    } else {
                                                        System.out.println("Incorrect input");
                                                        FileWorker.writeLogger("Incorrect input");
                                                        continue;
                                                    }
                                                }
                                            }while (input!=0);
                                        }
                                        else
                                        {
                                            System.out.println("bill is empty ");
                                            FileWorker.writeLogger("bill is empty ");
                                            continue;
                                        }


                                }
                                else
                                {
                                    System.out.println("Bill is empty");
                                    FileWorker.writeLogger("Bill is empty");
                                }
                                break;
                            case 4:
                                int countOfBeverages = client.getBill().getBeverages().size();
                                if(countOfBeverages>0) {
                                    do {
                                        System.out.println("======================================================");
                                        System.out.println("From which beverages do you want to remove ingredient ");
                                        System.out.println("Enter '0' to back in the last menu");
                                        billService.showResultBill(client);
                                        int numberOfBeverage = InputData.inputNumber();
                                        input=numberOfBeverage;
                                        if(input!=0) {
                                            if (numberOfBeverage > 0 && numberOfBeverage <= countOfBeverages) {
                                                int countOfIngredients = clientService.getBeverageForEdit(client, --numberOfBeverage).getListOfIngredients().size();
                                                    if (countOfIngredients > 0) {
                                                        do {
                                                        System.out.println("Ingredients to delete:");
                                                        int index = 1;
                                                        for (AbstractIngredient ingredient : clientService.getBeverageForEdit(client, numberOfBeverage).getListOfIngredients()) {
                                                            System.out.println(index + ". " + ingredient);
                                                            index++;
                                                        }
                                                        System.out.println("Which ingredient do you want to delete");
                                                        System.out.println("Enter '0' to back in the last menu");
                                                        int numberOfIngredient = InputData.inputNumber();
                                                        input=numberOfIngredient;
                                                        if(input!=0) {
                                                            if (numberOfIngredient >= 0 && numberOfIngredient <= countOfIngredients) {
                                                                clientService.removeIngredientFromBill(client, numberOfBeverage, numberOfIngredient);
                                                                System.out.println("Ingredient was removed");
                                                                break;
                                                            } else {
                                                                System.out.println("Incorrect input of ingredient");
                                                                FileWorker.writeLogger("Incorrect input of ingredient");
                                                                continue;
                                                            }
                                                        }
                                                        }while (input!=0);
                                                    } else {
                                                        System.out.println("The ingredients is absent");
                                                        FileWorker.writeLogger("The ingredients is absent");
                                                        break;
                                                    }


                                            } else {
                                                System.out.println("Incorrect input of beverage");
                                                FileWorker.writeLogger("Incorrect input of beverage");
                                                continue;
                                            }
                                        }
                                    }while (input!=0);
                                }
                                else
                                {
                                    System.out.println("Bill is empty");
                                    FileWorker.writeLogger("Bill is empty");
                                }
                                break;
                            case 5:
                                coffeeMachineService.showAssortiment(coffeeMachine);
                                break;
                            case 6:
                                System.out.println("***************Bill***********************");
                                billService.showResultBill(client);
                                break;
                            case 7:
                                break;
                                default:
                                    System.out.println("Incorrect input ");
                                    FileWorker.writeLogger("Incorrect input ");
                                    continue;

                        }


                    }while (input!=7);
                    break;
                case 3:
                    Serializator.serialization(client,"src"+ File.separator+"main"+File.separator+"resources"+File.separator+"client");
                    Serializator.serialization(coffeeMachine,"src"+ File.separator+"main"+File.separator+"resources"+File.separator+"coffeeMachine");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input");
                    FileWorker.writeLogger("Incorrect input");
                    break;


            }
        }
    }

    static public void Initialiaze()
    {
        try {
            client = (Client)Deserializator.deserialization("src" + File.separator + "main" + File.separator + "resources" + File.separator + "client");
        } catch (InvalidObjectException e) {
            client=new Client();
        }
        try {
            coffeeMachine = (CoffeeMachine) Deserializator.deserialization("src" + File.separator + "main" + File.separator + "resources" + File.separator + "coffeeMachine");
        } catch (InvalidObjectException e) {
            coffeeMachine=new CoffeeMachine();
        }
        clientService=new ClientService(coffeeMachine);
        coffeeMachineService=new CoffeeMachineService();
        adminService=new AdminService();
        billService=new BillService();
    }



}
