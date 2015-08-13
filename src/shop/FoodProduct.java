/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.Serializable;

/**
 *
 * @author kb0m
 */
public class FoodProduct extends Product implements Serializable {
    private int calories;

    public FoodProduct(String productName, double price, int quantity, int calories) {
        this.setProductName(productName);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setCalories(calories);
    }
    
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
