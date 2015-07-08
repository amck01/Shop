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
        boolean existsInCart = false;
        
        if (Shop.cart.isEmpty()) {
            Shop.cart.add(selection);
        } else {
            for (Product cartProduct : Shop.cart) {
                if (selection.getProductName() == cartProduct.getProductName()) {
                    cartProduct.setQuantity(cartProduct.getQuantity() + selection.getQuantity());
                    existsInCart = true;
                }
            }
        
            if (existsInCart == false) {
                Shop.cart.add(selection);
            }
        }
    }
}
