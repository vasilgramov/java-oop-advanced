package p03_coffeeMachine.models;

import p03_coffeeMachine.enums.CoffeeSize;
import p03_coffeeMachine.enums.CoffeeType;

import java.lang.annotation.ElementType;

public class Coffee {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.setCoffeeType(coffeeType);
        this.setCoffeeSize(coffeeSize);
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeType;
    }

    private void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public CoffeeSize getCoffeeSize() {
        return this.coffeeSize;
    }

    private void setCoffeeSize(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public String toString() {
        String sizeToPrint = this.getCoffeeSize().name().charAt(0) + this.getCoffeeSize().name().substring(1).toLowerCase();
        String typeToPrint = this.getCoffeeType().name().charAt(0) + this.getCoffeeType().name().substring(1).toLowerCase();

        return String.format("%s %s", sizeToPrint, typeToPrint);
    }
}
