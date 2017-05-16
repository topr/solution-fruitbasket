package exercise.fruits;

import exercise.fruits.calculators.CostCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BaseBasket implements Basket {

    private static final BigDecimal HUNDRED = new BigDecimal(100);

    private final Map<String, CostCalculator> itemToCostCalculatorMap;
    private final List<String> items;

    public BaseBasket(Map<String, CostCalculator> itemToCostCalculatorMap) {
        this.itemToCostCalculatorMap = itemToCostCalculatorMap;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(String item) {
        validateHasCalculatorFor(item);
        items.add(item);
    }

    @Override
    public BigDecimal calculateTotalCost() {
        long totalInPennies = items
                .stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .map(this::calculateItemCost)
                .mapToInt(Integer::intValue)
                .sum();

        return new BigDecimal(totalInPennies)
                .divide(HUNDRED, 2, RoundingMode.HALF_EVEN);
    }

    private int calculateItemCost(Map.Entry<String, Long> itemEntry) {
        String itemName = itemEntry.getKey();
        int amount = itemEntry.getValue().intValue();
        CostCalculator costCalculator = itemToCostCalculatorMap.get(itemName);

        return costCalculator.calculateCost(amount);
    }

    private void validateHasCalculatorFor(String item) {
        if (!itemToCostCalculatorMap.containsKey(item)) {
            throw new IllegalArgumentException("No cost calculator defined for item: " + item);
        }
    }
}
