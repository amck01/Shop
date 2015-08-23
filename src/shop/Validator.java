
package shop;

import java.util.Scanner;

/**
 *
 * @author kb0m
 */
public class Validator {
    
    public static int getInt(String textPrompt, int numOfOptions) {
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        
        do {
            System.out.print(textPrompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid selection");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice <= 0 || choice > numOfOptions);
        
        sc.nextLine();
        
        return choice;
    }
    
    public static int getInt(String textPrompt) {
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        
        do {
            System.out.print(textPrompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid selection");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice <= 0);
        
        sc.nextLine();
        
        return choice;
    }
}
