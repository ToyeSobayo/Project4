package com.example.pizzaparty;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomPizza extends Pizza {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public CustomPizza() {
        toppingsIncrement = 0.0;
        extraSauce = false;
        extraCheese = false;
    }

    @Override
    public double calculateSizePrice() {
        switch (this.size) {
            case SMALL:
                return 8.99;
            case MEDIUM:
                return 10.99;
            default:
                return 12.99;
        }
    }

    @Override
    public double calculatePrice() {
        return Double.parseDouble(df.format(calculateSizePrice() + calculateCheesePrice() + calculateSaucePrice() + toppingsIncrement));
    }

    @Override
    public String listToppings() {
        if (this.toppings == null || this.toppings.isEmpty()) {
            return "";
        }
        List<String> toppingNames = new ArrayList<>();
        for (Topping topping : this.toppings) {
            toppingNames.add(topping.toString());
        }
        return String.join(", ", toppingNames);
    }

    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String toString() {
        String base = "[Custom Pizza][" + getSizeAsString() + "][" + getSauceAsString() + "]: ";
        String toppingList = listToppings();
        String cheese = extraCheeseString().replace(",", "");
        String sauce = extraSauceString().replace(",", "");
        String priceString = ": $" + calculatePrice();
        return base + toppingList + (extraCheese || extraSauce ? cheese + sauce : "") + priceString;
    }
}
