
package shop;

import java.util.Scanner;

/**
 *
 * @author kb0m
 */
public class Validator {
    
    public static int getPositiveInt(String textPrompt) {
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
        
        return choice;
    }
    
    /*public static String getItemChoice() {
        Scanner sc = new Scanner(System.in);
        
        String choice;
        String itemNumber;
        String itemQuantity;
        
        do {
            System.out.print("Choice: ");
            while(!sc.hasNextLine()) {
                System.out.println("Invalid selection");
                sc.next();
            }
            choice = sc.nextLine();
            String[] choiceTokens = choice.split(" ");
            itemNumber = choiceTokens[0];
            itemQuantity = choiceTokens[1];
        } while (choice.length() == 3 && Character.isDigit(itemNumber.charAt(0)[]) == true && Character.isDigit(itemQuantity.charAt(0)) == true);
        // need to have this split choice into two tokens and test that each are an int
    }
    */
}
