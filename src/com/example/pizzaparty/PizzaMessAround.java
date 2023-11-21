package com.example.pizzaparty;

import java.util.ArrayList;

public class PizzaMessAround {
    public static void main(String[] args) {
        // Creating a Deluxe pizza
        Pizza deluxePizza = new Deluxe();
        deluxePizza.setSauce(Sauce.TOMATO);
        deluxePizza.setSize(Size.LARGE);

        // Creating an order with the Deluxe pizza
        Order orderDeluxe = new Order(new ArrayList<>(List.of(deluxePizza)));

        // Creating a Supreme pizza
        Pizza supremePizza = new Supreme();
        supremePizza.setSauce(Sauce.TOMATO);
        supremePizza.setSize(Size.MEDIUM);

        // Creating a Meatzza pizza
        Pizza meatzzaPizza = new Meatzza();
        meatzzaPizza.setSauce(Sauce.ALFREDO);
        meatzzaPizza.setSize(Size.SMALL);

        // Creating an order with the Meatzza pizza
        Order orderMeatzza = new Order(new ArrayList<>(List.of(meatzzaPizza)));

        // Managing orders in the store
        StoreOrders storeOrders = new StoreOrders(new ArrayList<>());
        storeOrders.add(orderDeluxe);
        storeOrders.add(orderMeatzza);

        // Uncomment to print store orders
        // System.out.println(storeOrders.toString());

        // Printing a specific order
        System.out.println(orderMeatzza.toString());
    }
}
