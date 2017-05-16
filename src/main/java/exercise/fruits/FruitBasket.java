package exercise.fruits;

import exercise.fruits.calculators.BuyOneGetOneFreeCostCalculator;
import exercise.fruits.calculators.CostCalculator;
import exercise.fruits.calculators.RegularCostCalculator;
import exercise.fruits.calculators.ThreeForTwoCostCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FruitBasket implements Basket {

    private static final Map<String, CostCalculator> COST_CALCULATORS = new HashMap<String, CostCalculator>() {{
        put("Apple", new RegularCostCalculator(35));
        put("Banana", new RegularCostCalculator(20));
        put("Melon", new BuyOneGetOneFreeCostCalculator(50));
        put("Lime", new ThreeForTwoCostCalculator(15));
    }};

    private final Basket delegate = new BaseBasket(COST_CALCULATORS);

    @Override
    public void add(String item) {
        delegate.add(item);
    }

    @Override
    public BigDecimal calculateTotalCost() {
        return delegate.calculateTotalCost();
    }
}
