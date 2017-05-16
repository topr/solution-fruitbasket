import exercise.fruits.Basket;
import exercise.fruits.FruitBasket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class FruitBasketApp {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList(args);
        Basket basket = new FruitBasket();

        fruits.forEach(basket::add);
        BigDecimal basketCost = basket.calculateTotalCost();

        System.out.println("Basket contains: " + fruits);
        System.out.println("Total cost = £" + basketCost);
    }
}
