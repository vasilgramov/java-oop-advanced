package p03_coffeeMachine.models;

import p03_coffeeMachine.enums.CoffeeSize;
import p03_coffeeMachine.enums.CoffeeType;
import p03_coffeeMachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeesSold;
    private int insertedMoney;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
    }

    public void insertCoin(String coin) {
        Coin currentCoin = Coin.valueOf(coin.toUpperCase());
        int value = currentCoin.getValue();
        this.insertedMoney += value;
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeesSold;
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());

        int neededMoney = coffeeSize.getPrice();
        if (this.insertedMoney >= neededMoney) {
            this.insertedMoney = 0;
            Coffee coffee = new Coffee(coffeeSize, coffeeType);
            this.coffeesSold.add(coffee);
        }
    }
}
