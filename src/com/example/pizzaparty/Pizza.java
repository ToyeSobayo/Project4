package com.example.pizzaparty;

import java.util.List;
import java.util.Objects;

public abstract class Pizza {
    protected List<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected double toppingsPriceIncrement;
    protected boolean hasExtraSauce;
    protected boolean hasExtraCheese;

    public abstract double price();

    public abstract double getSizePrice();

    public abstract String formatToppings();

    public abstract List<Topping> getToppings();

    public void setToppings(List<Topping> newToppings) {
        this.toppings = newToppings;
    }

    public double getExtraCheesePrice() {
        return hasExtraCheese ? 1.00 : 0.0;
    }

    public double getExtraSaucePrice() {
        return hasExtraSauce ? 1.00 : 0.0;
    }

    public String getExtraCheeseString() {
        return hasExtraCheese ? ", Extra cheese" : "";
    }

    public String getExtraSauceString() {
        return hasExtraSauce ? ", Extra sauce" : "";
    }

    public void increaseToppingsPrice() {
        toppingsPriceIncrement += 1.49;
    }

    public void decreaseToppingsPrice() {
        toppingsPriceIncrement -= 1.49;
    }

    public double getToppingsPriceIncrement() {
        return toppingsPriceIncrement;
    }

    public void setSize(Size newSize) {
        this.size = newSize;
    }

    public void setSauce(Sauce newSauce) {
        this.sauce = newSauce;
    }

    public void toggleExtraSauce() {
        hasExtraSauce = !hasExtraSauce;
    }

    public void toggleExtraCheese() {
        hasExtraCheese = !hasExtraCheese;
    }

    public Size getSize() {
        return size;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public String getSizeAsString() {
        return size.toString();
    }

    public String getSauceAsString() {
        return sauce.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pizza) {
            Pizza otherPizza = (Pizza) obj;
            return toppings.equals(otherPizza.getToppings()) && Double.compare(price(), otherPizza.price()) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toppings, size, sauce, toppingsPriceIncrement, hasExtraSauce, hasExtraCheese);
    }
}
