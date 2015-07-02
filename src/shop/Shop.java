
package shop;

/**
 *
 * @author kb0m
 */
public class Shop {

    public static void main(String[] args) {
        
        String[] mainMenuItems = new String[] {"Catalog","View Cart","Checkout","Order Lookup","Exit"};
        
        System.out.println("Shop\n----");
        Menu.printMenu(mainMenuItems);
        int choice = Validator.getInt();
        System.out.println(choice);
        
    }
    
}
