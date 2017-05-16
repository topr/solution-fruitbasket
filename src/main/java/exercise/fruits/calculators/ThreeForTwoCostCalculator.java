package exercise.fruits.calculators;

public class ThreeForTwoCostCalculator implements CostCalculator {

    private final int price;

    public ThreeForTwoCostCalculator(int priceInPennies) {
        this.price = priceInPennies;
    }

    @Override
    public int calculateCost(int amount) {
        return amount / 3 * price * 2 + amount % 3 * price;
    }
}
