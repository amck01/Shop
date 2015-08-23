/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author kb0m
 */
public class Cart {
    
    public static ArrayList<Product> cartList = new ArrayList<Product>();
    
    public static void addToCart(FoodProduct selection) {
        if (cartList.isEmpty()) {
            cartList.add(new FoodProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getCalories()));
        } else {
            boolean existsInCart = false;
            for (int i = 0; i < cartList.size(); i++) {
                if (selection.getProductName().equals(cartList.get(i).getProductName())) {
                    cartList.get(i).setQuantity(cartList.get(i).getQuantity() + selection.getQuantity());
                    existsInCart = true;
                    break;
                }
            }
                
            if (existsInCart == false) {
                cartList.add(new FoodProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getCalories()));
            }
        }
    }
    
    public static void addToCart(DrinkProduct selection) {
        if (cartList.isEmpty()) {
            cartList.add(new DrinkProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getOunces()));
        } else {
            boolean existsInCart = false;
            for (int i = 0; i < cartList.size(); i++) {
                if (selection.getProductName().equals(cartList.get(i).getProductName())) {
                    cartList.get(i).setQuantity(cartList.get(i).getQuantity() + selection.getQuantity());
                    existsInCart = true;
                    break;
                }
            }
                
            if (existsInCart == false) {
                cartList.add(new DrinkProduct(selection.getProductName(),selection.getPrice(), selection.getQuantity(), selection.getOunces()));
            }
        }
    }
    
    public static void saveCart(Cart cart) {
        try {
            FileOutputStream fos = new FileOutputStream("cart.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cart.cartList);
            oos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void restoreCart() {
        Path cartFile = Paths.get("cart.ser");
        if (Files.exists(cartFile)) {
            try {
                FileInputStream fis = new FileInputStream("cart.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Cart.cartList = (ArrayList<Product>) ois.readObject();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void clearCart(Cart cart) {
        cart.cartList.clear();
    }
}
