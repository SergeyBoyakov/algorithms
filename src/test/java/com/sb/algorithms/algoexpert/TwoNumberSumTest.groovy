package com.sb.algorithms.algoexpert

import spock.lang.Specification

class TwoNumberSumTest extends Specification {

    def 'test'() {
        given:
        def calculator = new TwoNumberSum()

        expect:
        calculator.myTwoNumberSum(arr as int[], target as int) == result

        where:
        arr    | target | result
        [4, 6] | 10     | [4, 6]
    }
}
