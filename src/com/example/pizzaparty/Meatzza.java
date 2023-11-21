package com.example.pizzaparty;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Meatzza extends Pizza {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Meatzza() {
        toppings = List.of(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM);
        sauce = Sauce.TOMATO;
    }

    @Override
    public double calculateSizePrice() {
        return switch (this.size) {
            case SMALL -> 16.99;
            case MEDIUM -> 18.99;
            default -> 20.99;
        };
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
        return String.format("[Meatzza][%s][%s]: %s%s%s: $%.2f",
                getSizeAsString(), getSauceAsString(), listToppings(), extraCheeseString(), extraSauceString(), calculatePrice());
    }
}
