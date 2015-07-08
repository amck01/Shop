
package shop;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Catalog {
    
    public static void initializeCatalog() {
        Shop.foodCatalog = new ArrayList<FoodProduct>();
        Shop.drinkCatalog = new ArrayList<DrinkProduct>();
        
        Shop.foodCatalog.add(new FoodProduct("Ice Cream",2.50,1,400));
        Shop.foodCatalog.add(new FoodProduct("Pizza",3.00,1,300));
        
        Shop.drinkCatalog.add(new DrinkProduct("Milk",1.50,1,20));
        Shop.drinkCatalog.add(new DrinkProduct("Soda",1.00,1,24));
    }
    
    public static void printFoodCatalog() {
        
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        for (Product foodProduct : Shop.foodCatalog) {
            System.out.println((Shop.foodCatalog.indexOf(foodProduct)+1) + ". " + foodProduct.getProductName() + " - " + numberFormatter.format(foodProduct.getPrice()));
        }
        System.out.println((Shop.foodCatalog.size() + 1) + ". Return to Catalog");
    }
    
}
