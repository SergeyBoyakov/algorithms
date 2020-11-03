package com.sb.algorithms.leetcode

import spock.lang.Specification

class ReverseIntegerSpec extends Specification {
    def reverse = new ReverseInteger()

    def 'should reverse input integer'() {
        expect:
        reverse.reverse(input) == output

        where:
        input      | output
        12         | 21
        1534236469 | 9646324351
    }


}
