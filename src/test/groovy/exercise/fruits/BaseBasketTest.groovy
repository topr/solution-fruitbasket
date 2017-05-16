package exercise.fruits

import exercise.fruits.calculators.CostCalculator
import spock.lang.Specification
import spock.lang.Subject

class BaseBasketTest extends Specification {

    def fooCalculator = Mock(CostCalculator)
    def barCalculator = Mock(CostCalculator)
    def zazCalculator = Mock(CostCalculator)

    @Subject BaseBasket basket

    def 'resolves cost calculator by item name and calls it with its amount'() {
        given:
            basketCreatedWithCalculators(foo: fooCalculator, bar: barCalculator, zaz: zazCalculator)
            basketContainsItems('foo', 'bar', 'foo', 'foo', 'bar')

        when:
            basket.calculateTotalCost()

        then:
            1 * fooCalculator.calculateCost(3)
            1 * barCalculator.calculateCost(2)
            0 * zazCalculator.calculateCost(_)
    }

    def 'fails with meaningful message upon add when no calculator is defined for a given item'() {
        given:
            basketCreatedWithCalculators(foo: fooCalculator)
            def itemName = 'plop'

        when:
            basket.add(itemName)

        then:
            def ex = thrown(IllegalArgumentException)
            ex.message == "No cost calculator defined for item: $itemName"
    }

    def 'returns sum of calculated costs divided by 100'() {
        given:
            basketCreatedWithCalculators(foo: fooCalculator, bar: zazCalculator, zaz: barCalculator)
            basketContainsItems('foo', 'bar', 'zaz')

        and:
            fooCalculator.calculateCost(_) >> 11
            zazCalculator.calculateCost(_) >> 22
            barCalculator.calculateCost(_) >> 33

        expect:
            basket.calculateTotalCost() == 0.66
    }

    void basketCreatedWithCalculators(Map<String, CostCalculator> calculatorMap) {
        this.basket = new BaseBasket(calculatorMap)
    }

    void basketContainsItems(String... items) {
        items.each(basket.&add)
    }
}
