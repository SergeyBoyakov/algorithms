package com.sb.algorithms.codewars

import spock.lang.Specification

class AlternateCapitalizationSpec extends Specification {

    def 'should capitalize even and odd'() {
        expect:
        new AlternateCapitalization().capitalize(input) == result

        where:
        input    || result
        "abcdef" || ["AbCdEf", "aBcDeF"]
    }
}
