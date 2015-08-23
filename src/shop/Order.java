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

/**
 *
 * @author BigKa
 */
public class Order {
    // TODO - Order class, get current order ID from file, increment then overwrite?
    private ArrayList<Product> order;
    private int orderID; 
    
    public Order(ArrayList<Product> cart) {
        this.order = new ArrayList<>(cart);
    }     
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orderID + ";");
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
        
        return stringBuilder.toString();
    }
    
    public static int getNextID() throws IOException {
        Path currentIDFile = Paths.get("currentID.txt");
        int currentID;
        if (Files.exists(currentIDFile)) {
            try {                
                BufferedReader bufferedReader = new BufferedReader(new FileReader("currentID.txt"));
                currentID = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.close();
                
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("currentID.txt",false));
                currentID++;
                bufferedWriter.write(Integer.toString(currentID));
                bufferedWriter.close();
                return currentID;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
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
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("orders.txt", true));
        bufferedWriter.write(this.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
