package com.example.pizzaparty;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Supreme extends Pizza {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Supreme() {
        toppings = List.of(Topping.SAUSAGE, Topping.PEPPERONI, Topping.HAM, Topping.GREENPEPPER, Topping.ONION, Topping.BLACKOLIVE, Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    @Override
    public double calculateSizePrice() {
        return switch (this.size) {
            case SMALL -> 15.99;
            case MEDIUM -> 17.99;
            default -> 19.99;
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
        return String.format("[Supreme][%s][%s]: %s%s%s: $%.2f",
                getSizeAsString(), getSauceAsString(), formatToppings(), getExtraCheeseString(), getExtraSauceString(), calculatePrice());
    }
}
