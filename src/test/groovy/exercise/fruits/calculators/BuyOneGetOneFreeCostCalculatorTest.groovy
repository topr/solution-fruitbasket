package exercise.fruits.calculators

import spock.lang.Specification
import spock.lang.Unroll

class BuyOneGetOneFreeCostCalculatorTest extends Specification {

    @Unroll
    def 'calculates "buy one get one free" cost of #amount item(s) for the price #price to be #expectedCost'() {
        given:
            def calculator = new BuyOneGetOneFreeCostCalculator(price)

        when:
            def cost = calculator.calculateCost(amount)

        then:
            cost == expectedCost

        where:
            price | amount || expectedCost
            5     | 0      || 0
            0     | 5      || 0
            5     | 1      || 5
            5     | 2      || 5
            5     | 3      || 10
            5     | 4      || 10
            50    | 10     || 250
    }
}
