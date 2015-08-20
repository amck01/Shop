/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BigKa
 */
public class Order {
    // TODO - Order class, get current order ID from file, increment then overwrite?
    private ArrayList<Product> order;
    private int orderID; 
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(getNextID() + ";");
            for (int i = 0; i < order.size(); i++) {
                stringBuilder.append(order.get(i).getProductName() + ",");
                stringBuilder.append(order.get(i).getPrice() + ",");
                stringBuilder.append(order.get(i).getQuantity() + ",");
                if (order.get(i) instanceof FoodProduct) {
                    stringBuilder.append(((FoodProduct) order.get(i)).getCalories() + ",");
                    stringBuilder.append(";");
                } else if (order.get(i) instanceof DrinkProduct) {
                    stringBuilder.append(",");
                    stringBuilder.append(((DrinkProduct)order.get(i)).getOunces() + ";");
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return stringBuilder.toString();
    }
    
    public static int getNextID() throws IOException {
        Path currentIDFile = Paths.get("currentID.txt");
        int currentID = 1;
        if (Files.exists(currentIDFile)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("currentID.txt"));
                currentID = Integer.parseInt(bufferedReader.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return currentID;
        }
        else {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("currentID.txt"));
                bufferedWriter.write("1");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
    }
    
    public void setOrderID(int id) {
        this.orderID = id;
    }
    
    public int getOrderID() {
        return this.orderID;
    }
    
    public void writeOrder() throws IOException {
        Path ordersPath = Paths.get("orders.txt");
        
        if (!Files.exists(ordersPath)) {
            Files.createFile(ordersPath);
        }
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("orders.txt"));
        bufferedWriter.write(order.toString());
    }
}
