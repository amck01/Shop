
package shop;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Catalog {
    
    public ArrayList<FoodProduct> foodCatalog = new ArrayList<FoodProduct>();
    public ArrayList<DrinkProduct> drinkCatalog = new ArrayList<DrinkProduct>();
    
    public void initializeCatalog() {
        foodCatalog.add(new FoodProduct("Ice Cream",2.50,1,400));
        foodCatalog.add(new FoodProduct("Pizza",3.00,1,300));
        
        drinkCatalog.add(new DrinkProduct("Milk",1.50,1,20));
        drinkCatalog.add(new DrinkProduct("Soda",1.00,1,24));
    }
    
    public void printFoodCatalog() {     
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        for (Product foodProduct : foodCatalog) {
            System.out.println((foodCatalog.indexOf(foodProduct)+1) + ". "
                    + foodProduct.getProductName() + " - " 
                    + numberFormatter.format(foodProduct.getPrice()));
        }
        System.out.println((foodCatalog.size() + 1) + ". Return to Catalog");
    }
    
    public void printDrinkCatalog() {
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        for (Product drinkProduct : drinkCatalog) {
            System.out.println((drinkCatalog.indexOf(drinkProduct)+1) + ". "
                    + drinkProduct.getProductName() + " - " 
                    + numberFormatter.format(drinkProduct.getPrice()));
        }
        System.out.println((drinkCatalog.size() + 1) + ". Return to Catalog");
    }
    
}
