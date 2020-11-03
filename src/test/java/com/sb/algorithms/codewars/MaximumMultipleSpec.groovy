package com.sb.algorithms.codewars

import spock.lang.Specification

class MaximumMultipleSpec extends Specification {
    def 'first test'() {
        expect:
        MaximumMultiple.maxMultiple(divisor, bound) == result

        where:
        divisor | bound | result
        2       | 7     | 6

    }
}
