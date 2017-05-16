package exercise.fruits.calculators

import spock.lang.Specification
import spock.lang.Unroll

class ThreeForTwoCostCalculatorTest extends Specification {

    @Unroll
    def 'calculates "three for two" cost of #amount item(s) for the price #price to be #expectedCost'() {
        given:
            def calculator = new ThreeForTwoCostCalculator(price)

        when:
            def cost = calculator.calculateCost(amount)

        then:
            cost == expectedCost

        where:
            price | amount || expectedCost
            5     | 0      || 0
            0     | 5      || 0
            5     | 1      || 5
            5     | 2      || 10
            5     | 3      || 10
            5     | 4      || 15
            50    | 10     || 350
    }
}
