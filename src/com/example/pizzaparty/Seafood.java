package com.example.pizzaparty;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Seafood extends Pizza {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Seafood() {
        toppings = List.of(Topping.SHRIMP, Topping.SQUID, Topping.CRABMEATS);
        sauce = Sauce.ALFREDO;
    }

    @Override
    public double calculateSizePrice() {
        return switch (this.size) {
            case SMALL -> 17.99;
            case MEDIUM -> 19.99;
            default -> 21.99;
        };
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
        return String.format("[Seafood][%s][%s]: %s%s%s: $%.2f",
                getSizeAsString(), getSauceAsString(), formatToppings(), getExtraCheeseString(), getExtraSauceString(), calculatePrice());
    }
}
