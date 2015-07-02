/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.Scanner;

/**
 *
 * @author kb0m
 */
public class Validator {
    
    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        System.out.print("Choice: ");
        
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid selection");
            getInt();
        }
        
        if (choice <= 0) {
            System.out.println("Invalid selection");
            continue;
        } else {
            return choice;
        }
        
        return 0;
    }
}
