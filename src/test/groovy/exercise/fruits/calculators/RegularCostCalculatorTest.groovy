package exercise.fruits.calculators

import spock.lang.Specification
import spock.lang.Unroll

class RegularCostCalculatorTest extends Specification {

    @Unroll
    def 'calculates regular cost of #amount item(s) for the price #price to be #expectedCost'() {
        given:
            def calculator = new RegularCostCalculator(price)

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
            5     | 3      || 15
            5     | 4      || 20
            50    | 10     || 500
    }
}
