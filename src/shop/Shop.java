
package shop;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Shop {
    
    public static ArrayList<FoodProduct> foodCatalog;
    public static ArrayList<DrinkProduct> drinkCatalog;
    public static ArrayList<Product> cart;
        
    public static void main(String[] args) {
        
        Catalog.initializeCatalog();
        Cart.initializeCart();
        Shop shop = new Shop();
        shop.mainMenu();
        
    }
    
    private void mainMenu() {
        String[] mainMenuItems = {"Catalog","View Cart","Checkout","Order Lookup","Exit"};
        
        System.out.println("\nShop\n----");
        Menu.printMenu(mainMenuItems);
        
        int choice = Validator.getPositiveInt("Choice: ");
        
        switch (choice) {
            case 1:  catalogMenu();
            case 2: viewCart();    
                
            case 5: System.exit(0); 
                    break;
        }
    }
    
    private void catalogMenu() {
        String[] catalogMenuItems = {"Food","Drink","Return to Main Menu"};
        
        System.out.println("\nCatalog\n-------");
        Menu.printMenu(catalogMenuItems);
        
        int choice = Validator.getPositiveInt("Choice: ");
        
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
        Catalog.printFoodCatalog();
        
        int choice = Validator.getPositiveInt("Item: ");
        if (choice >= 1 && choice <= Shop.foodCatalog.size()) {
            int quantity = Validator.getPositiveInt("Quantity: ");
            FoodProduct selection = foodCatalog.get(choice-1);
            selection.setQuantity(quantity);
            Cart.addToCart(selection);
            System.out.println("\nItem added to cart!\n");
            foodMenu();
        } else {
            catalogMenu();
        }
                
        /*switch (choice) {
            case 1:  quantity = Validator.getPositiveInt("Quantity: ");
                     cart.add(new FoodProduct(foodMenuItems[0],2.50,quantity,100));
                     System.out.println("Item added to cart!");
                     foodMenu();
                     break;
            case 2:  quantity = Validator.getPositiveInt("Quantity: ");
                     cart.add(new FoodProduct(foodMenuItems[1],3.00,quantity, 200));
                     System.out.println("\nItem added to cart!\n");
                     foodMenu();
                     break;
            case 3:  catalogMenu();
                     break;
        } */
    }

    private void drinkMenu() {
        String[] drinkMenuItems = {"Milk","Soda","Return to Catalog"};
        
        System.out.println("\nDrinks\n-------");
        Menu.printMenu(drinkMenuItems);
        
        int choice = Validator.getPositiveInt("Item: ");
        int quantity;
                
        switch (choice) {
            case 1:  quantity = Validator.getPositiveInt("Quantity: ");
                     cart.add(new DrinkProduct(drinkMenuItems[0],2.50,quantity,100));
                     System.out.println("Item added to cart!");
                     drinkMenu();
                     break;
            case 2:  quantity = Validator.getPositiveInt("Quantity: ");
                     cart.add(new DrinkProduct(drinkMenuItems[1],3.00,quantity, 200));
                     System.out.println("\nItem added to cart!\n");
                     drinkMenu();
                     break;
            case 3:  catalogMenu();
                     break;
        }
    }

    private void viewCart() {        
        System.out.print("\nCart\n----");
        
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        
        for(Product item : cart) {
            System.out.println("\n" + item.getProductName());
            System.out.println("Price: " + numberFormatter.format((item.getQuantity() * item.getPrice())));
            System.out.println(item.getQuantity() + "\n");
        }
        mainMenu();
    } 
}
