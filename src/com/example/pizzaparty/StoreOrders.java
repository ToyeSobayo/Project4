package com.example.pizzaparty;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StoreOrders {
    private List<Order> orders;
    private int currentOrderNumber;

    public StoreOrders() {
        this.orders = new ArrayList<>();
        this.currentOrderNumber = 1;
    }

    public StoreOrders(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
        this.currentOrderNumber = 1;
    }

    public void addOrder(Order order) {
        order.setOrderNumber(currentOrderNumber++);
        this.orders.add(order);
    }

    public boolean removeOrder(Order order) {
        return orders.removeIf(o -> o.getOrderNumber() == order.getOrderNumber());
    }

    public int getNextOrderNumber() {
        return orders.stream()
                .mapToInt(Order::getOrderNumber)
                .max()
                .orElse(0) + 1;
    }

    public void exportOrders() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Order File");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Order> getOrders() {
        return new ArrayList<>(this.orders);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Order order : this.orders) {
            res.append("Order number ").append(order.getOrderNumber()).append("\n").append(order).append("\n");
        }
        return res.toString();
    }

    public void setOrders(List<Order> newOrders) {
        this.orders = new ArrayList<>(newOrders);
    }
}
