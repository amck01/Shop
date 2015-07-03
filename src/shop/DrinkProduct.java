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
public class DrinkProduct extends Product {
    private int ounces;

    public DrinkProduct(String productName, double price, int ounces) {
        this.setProductName(productName);
        this.setPrice(price);
        this.setOunces(ounces);
    }
    
    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }
}
