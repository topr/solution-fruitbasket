package exercise.fruits;

import java.math.BigDecimal;

public interface Basket {
    void add(String item);
    BigDecimal calculateTotalCost();
}
