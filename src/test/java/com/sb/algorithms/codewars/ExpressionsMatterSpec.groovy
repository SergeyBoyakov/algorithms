package com.sb.algorithms.codewars

import spock.lang.Specification

class ExpressionsMatterSpec extends Specification {

    def 'first tests'() {
        expect:
        ExpressionsMatter.expressionsMatter(first, second, third) == result

        where:
        first | second | third || result
        1     | 2      | 3     || 9
        2     | 1      | 2     || 6
        1     | 1      | 1     || 3
        1     | 3      | 1     || 5
        2     | 2      | 2     || 8
    }
}
