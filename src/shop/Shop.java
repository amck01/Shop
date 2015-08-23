
package shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kb0m
 */
public class Shop {
    
    public static Catalog catalog = new Catalog();
    public static Cart cart = new Cart();
        
    public static void main(String[] args) throws IOException {      
        catalog.initializeCatalog();
        Cart.restoreCart();
        Shop shop = new Shop();
        shop.mainMenu();
        
    }
    
    private void mainMenu() throws IOException {
        final String[] mainMenuItems = {"Catalog","View Cart","Clear Cart","Checkout","Order Lookup","Exit"};
        
        System.out.println("\nShop\n----");
        Menu.printMenu(mainMenuItems);
        
        int choice = Validator.getInt("Choice: ", mainMenuItems.length);
        
        switch (choice) {
            case 1: catalogMenu();
                    break;
            case 2: viewCart(); 
                    break;
            case 3: Cart.clearCart(cart);
                    mainMenu();
                    break;
            case 4: checkout();
                    break;
            case 5: orderLookup();
                    break;
            case 6: Cart.saveCart(cart);
                    System.exit(0); 
                    break;
        }
    }
    
    // TODO - Condense menu methods?
    
    private void catalogMenu() throws IOException {
        final String[] catalogMenuItems = {"Food","Drink","Return to Main Menu"};
        
        System.out.println("\nCatalog\n-------");
        Menu.printMenu(catalogMenuItems);
        
        int choice = Validator.getInt("Choice: ", catalogMenuItems.length);
        
        switch (choice) {
            case 1:  foodMenu();
                     break;
            case 2:  drinkMenu();
                     break;
            case 3:  mainMenu();
                     break;
        }
    }

    private void foodMenu() throws IOException {
        System.out.println("\nFood\n-------");
        catalog.printFoodCatalog();
        
        int choice = Validator.getInt("Item: ");
        if (choice >= 1 && choice <= catalog.foodCatalog.size()) {
            int quantity = Validator.getInt("Quantity: ");
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

    private void drinkMenu() throws IOException {
        System.out.println("\nDrinks\n-------");
        catalog.printDrinkCatalog();
        
        int choice = Validator.getInt("Item: ");
        if (choice >= 1 && choice <= catalog.drinkCatalog.size()) {
            int quantity = Validator.getInt("Quantity: ");
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

    private void viewCart() throws IOException {        
        System.out.print("\nCart\n----");
        
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        
        for(Product item : cart.cartList) {
            System.out.println("\n" + item.getProductName());
            System.out.println("Price: " + numberFormatter.format((item.getQuantity() * item.getPrice())));
            System.out.println(item.getQuantity() + "\n");
        }
        mainMenu();
    }
    
    private void checkout() throws IOException {
        Order order = new Order(cart.cartList);
        order.setOrderID(Order.getNextID());
        order.writeOrder();
        System.out.println("\nOrder saved!\n");
        mainMenu();
    }
    
    private void orderLookup() throws IOException {
        
        int choice = Validator.getInt("Order ID: ");
        //Path ordersPath = Paths.get("orders.txt");
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader("orders.txt"));
        String[] orderLine;
        do {
            orderLine = bufferedReader.readLine().split(";");
        } while (Integer.parseInt(orderLine[0]) != choice);
        bufferedReader.close();
        System.out.println(Arrays.toString(orderLine));
        mainMenu();
    }
}
