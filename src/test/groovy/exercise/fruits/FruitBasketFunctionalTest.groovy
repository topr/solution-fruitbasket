package exercise.fruits

import spock.lang.Specification

class FruitBasketFunctionalTest extends Specification {

    def 'total cost of a fruit basket with #fruits is £#expectedCost'() {
        given:
            def fruits = [
                    'Banana', 'Lime', 'Melon', 'Apple',
                    'Banana', 'Lime', 'Melon', 'Apple',
                    'Banana', 'Lime', 'Melon',
                    'Banana', 'Lime'
            ]

        and:
            def basket = new FruitBasket()

        when:
            fruits.each(basket.&add)

        then:
            basket.calculateTotalCost() == 2.95
    }
}
