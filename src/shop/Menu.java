/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
