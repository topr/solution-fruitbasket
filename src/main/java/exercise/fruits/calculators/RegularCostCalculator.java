package exercise.fruits.calculators;

public class RegularCostCalculator implements CostCalculator {

    private final int price;

    public RegularCostCalculator(int priceInPennies) {
        this.price = priceInPennies;
    }

    @Override
    public int calculateCost(int amount) {
        return amount * price;
    }
}
