/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Cart {
    
    public static void initializeCart() {
        Shop.cart = new ArrayList<Product>();
    }
    
    public static void addToCart(Product selection) {
        if (Shop.cart.isEmpty()) {
            #Shop.cart.add(selection);
            Shop.cart.add(new FoodProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getCalories());
        } else {
            /*for (Product cartProduct : Shop.cart) {
                if (selection.getProductName().equals(cartProduct.getProductName())) {
                    cartProduct.setQuantity(cartProduct.getQuantity() + selection.getQuantity());
                } else {
                    Shop.cart.add(selection);
                }
            }*/
            boolean existsInCart = false;
            for (int i = 0; i < Shop.cart.size(); i++) {
                if (selection.getProductName().equals(Shop.cart.get(i).getProductName())) {
                    Shop.cart.get(i).setQuantity(Shop.cart.get(i).getQuantity() + selection.getQuantity());
                    existsInCart = true;
                    break;
                }
            }
                
            if (existsInCart == false) {
                    #Shop.cart.add(selection);
                    Shop.cart.add(new FoodProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getCalories());
            }
        }
    }
}
