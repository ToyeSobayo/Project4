package com.example.pizzaparty;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pepperoni extends Pizza {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Pepperoni() {
        toppings = Collections.singletonList(Topping.PEPPERONI);
        sauce = Sauce.TOMATO;
    }

    @Override
    public double calculateSizePrice() {
        switch (this.size) {
            case SMALL:
                return 10.99;
            case MEDIUM:
                return 12.99;
            default:
                return 14.99;
        }
    }

    @Override
    public double calculatePrice() {
        return Double.parseDouble(df.format(calculateSizePrice() + calculateCheesePrice() + calculateSaucePrice()));
    }

    @Override
    public String listToppings() {
        return toppings.stream().map(Topping::toString).collect(Collectors.joining(", "));
    }

    @Override
    public List<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String toString() {
        return String.format("[Pepperoni][%s][%s]: %s%s%s: $%.2f",
                getSizeAsString(), getSauceAsString(), listToppings(), extraCheeseString(), extraSauceString(), calculatePrice());
    }
}
