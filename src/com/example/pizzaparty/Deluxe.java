package com.example.pizzaparty;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class SupremePizza extends Pizza {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public SupremePizza() {
        extraSauce = false;
        extraCheese = false;
        toppings = List.of(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.ONION, Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    @Override
    public double calculateSizePrice() {
        switch (this.size) {
            case SMALL:
                return 14.99;
            case MEDIUM:
                return 16.99;
            default:
                return 18.99;
        }
    }

    @Override
    public double calculatePrice() {
        return Double.parseDouble(df.format(calculateSizePrice() + calculateCheesePrice() + calculateSaucePrice()));
    }

    @Override
    public String formatToppings() {
        return toppings.stream().map(Topping::toString).collect(Collectors.joining(", "));
    }

    @Override
    public List<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String toString() {
        return String.format("[Supreme Pizza][%s][%s]: %s%s%s: $%.2f",
                getSizeAsString(), getSauceAsString(), formatToppings(), extraCheeseString(), extraSauceString(), calculatePrice());
    }
}
