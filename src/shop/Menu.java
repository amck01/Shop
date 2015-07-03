
package shop;

/**
 *
 * @author kb0m
 */
public class Menu {
    
    public static void printMenu(String[] menuItems) {
        int menuItemNumber = 1;
        while (menuItemNumber <= menuItems.length) {
            System.out.println(menuItemNumber + ". " + menuItems[menuItemNumber-1]);
            menuItemNumber++;
        }
    }
}
