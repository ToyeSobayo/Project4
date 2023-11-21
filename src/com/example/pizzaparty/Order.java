package com.example.pizzaparty;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<Pizza> pizzas;
    private int orderNumber;
    public static final double SALES_TAX = 0.06625;
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Order(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int newOrderNumber) {
        this.orderNumber = newOrderNumber;
    }

    @Override
    public String toString() {
        String pizzaDetails = pizzas.stream()
                .map(Pizza::toString)
                .collect(Collectors.joining("\n"));
        return String.format("%s\n\nOrder total: $%.2f\n", pizzaDetails, getTotalPriceWithSalesTax());
    }

    public double getTotalPriceWithoutTax() {
        return Double.parseDouble(df.format(pizzas.stream().mapToDouble(Pizza::price).sum()));
    }

    public double getTotalPriceWithSalesTax() {
        double totalWithoutTax = getTotalPriceWithoutTax();
        return Double.parseDouble(df.format(totalWithoutTax * (1 + SALES_TAX)));
    }

    public double getSalesTaxOfTotal() {
        return Double.parseDouble(df.format(getTotalPriceWithoutTax() * SALES_TAX));
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> newPizzas) {
        this.pizzas = newPizzas;
    }
}
