
package shop;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Shop {
    
    public static Catalog catalog = new Catalog();
    public static Cart cart = new Cart();
        
    public static void main(String[] args) {      
        catalog.initializeCatalog();
        Cart.restoreCart();
        Shop shop = new Shop();
        shop.mainMenu();
        
    }
    
    private void mainMenu() {
        String[] mainMenuItems = {"Catalog","View Cart","Clear Cart","Checkout","Order Lookup","Exit"};
        
        System.out.println("\nShop\n----");
        Menu.printMenu(mainMenuItems);
        
        int choice = Validator.getMenuChoice("Choice: ", mainMenuItems.length);
        
        switch (choice) {
            case 1: catalogMenu();
                    break;
            case 2: viewCart(); 
                    break;
            case 3: Cart.clearCart(cart);
                    mainMenu();
                    break;
            case 6: Cart.saveCart(cart);
                    System.exit(0); 
                    break;
        }
    }
    
    private void catalogMenu() {
        String[] catalogMenuItems = {"Food","Drink","Return to Main Menu"};
        
        System.out.println("\nCatalog\n-------");
        Menu.printMenu(catalogMenuItems);
        
        int choice = Validator.getMenuChoice("Choice: ", catalogMenuItems.length);
        
        switch (choice) {
            case 1:  foodMenu();
                     break;
            case 2:  drinkMenu();
                     break;
            case 3:  mainMenu();
                     break;
        }
    }

    private void foodMenu() {
        System.out.println("\nFood\n-------");
        catalog.printFoodCatalog();
        
        int choice = Validator.getMenuChoice("Item: ");
        if (choice >= 1 && choice <= catalog.foodCatalog.size()) {
            int quantity = Validator.getMenuChoice("Quantity: ");
            FoodProduct selection = new FoodProduct(
                    catalog.foodCatalog.get(choice-1).getProductName(),
                    catalog.foodCatalog.get(choice-1).getPrice(),
                    catalog.foodCatalog.get(choice-1).getQuantity(),
                    catalog.foodCatalog.get(choice-1).getCalories());
            selection.setQuantity(quantity);
            Cart.addToCart(selection);
            System.out.println("\nItem added to cart!\n");
            foodMenu();
        } else {
            catalogMenu();
        }
    }

    private void drinkMenu() {
        System.out.println("\nDrinks\n-------");
        catalog.printDrinkCatalog();
        
        int choice = Validator.getMenuChoice("Item: ");
        if (choice >= 1 && choice <= catalog.drinkCatalog.size()) {
            int quantity = Validator.getMenuChoice("Quantity: ");
            DrinkProduct selection = new DrinkProduct(
                    catalog.drinkCatalog.get(choice-1).getProductName(),
                    catalog.drinkCatalog.get(choice-1).getPrice(),
                    catalog.drinkCatalog.get(choice-1).getQuantity(),
                    catalog.drinkCatalog.get(choice-1).getOunces());
            selection.setQuantity(quantity);
            Cart.addToCart(selection);
            System.out.println("\nItem added to cart!\n");
            drinkMenu();
        } else {
            catalogMenu();
        }
    }

    private void viewCart() {        
        System.out.print("\nCart\n----");
        
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        
        for(Product item : cart.cartList) {
            System.out.println("\n" + item.getProductName());
            System.out.println("Price: " + numberFormatter.format((item.getQuantity() * item.getPrice())));
            System.out.println(item.getQuantity() + "\n");
        }
        mainMenu();
    } 
}
