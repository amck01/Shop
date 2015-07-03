
package shop;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Shop {

    public static ArrayList<Product> Cart = new ArrayList<Product>();
        
    public static void main(String[] args) {
        
        Shop shop = new Shop();
        shop.mainMenu();
        
    }
    
    private void mainMenu() {
        String[] mainMenuItems = {"Catalog","View Cart","Checkout","Order Lookup","Exit"};
        
        System.out.println("Shop\n----");
        Menu.printMenu(mainMenuItems);
        
        int choice = Validator.getPositiveInt("Choice: ");
        
        switch (choice) {
            case 1:  catalogMenu();
            case 2: viewCart();    
                
            case 5:  break;
        }
    }
    
    private void catalogMenu() {
        String[] catalogMenuItems = {"Food","Drink","Return to Main Menu"};
        
        System.out.println("Catalog\n-------");
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
        String[] foodMenuItems = {"Ice Cream","Pizza","Return to Catalog"};
        
        System.out.println("Food\n-------");
        Menu.printMenu(foodMenuItems);
        
        int choice = Validator.getPositiveInt("Item: ");
        int quantity;
                
        switch (choice) {
            case 1:  quantity = Validator.getPositiveInt("Quantity: ");
                     Cart.add(new FoodProduct(foodMenuItems[0],2.50,quantity,100));
                     System.out.println("Item added to cart!");
                     foodMenu();
                     break;
            case 2:  quantity = Validator.getPositiveInt("Quantity: ");
                     Cart.add(new FoodProduct(foodMenuItems[1],3.00,quantity, 200));
                     System.out.println("\nItem added to cart!\n");
                     foodMenu();
                     break;
            case 3:  catalogMenu();
                     break;
        }
    }

    private void drinkMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewCart() {
        
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        
        for(Product item : Cart) {
            System.out.println("\n" + item.getProductName() + " - " + item.getQuantity());
            System.out.println("Price: " + numberFormatter.format((item.getQuantity() * item.getPrice())) + "\n");
        }
        mainMenu();
    }
    
}
