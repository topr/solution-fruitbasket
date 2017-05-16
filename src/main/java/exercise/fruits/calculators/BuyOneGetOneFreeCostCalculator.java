package exercise.fruits.calculators;

public class BuyOneGetOneFreeCostCalculator implements CostCalculator {

    private final int price;

    public BuyOneGetOneFreeCostCalculator(int priceInPennies) {
        this.price = priceInPennies;
    }

    @Override
    public int calculateCost(int amount) {
        return amount / 2 * price + amount % 2 * price;
    }
}
