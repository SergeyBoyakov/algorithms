package com.sb.algorithms.codewars

import spock.lang.Specification

class ClockSpec extends Specification {

    def 'should return milliseconds after midnight'() {
        expect:
        Clock.past(hours, minutes, seconds) == milliseconds

        where:
        hours | minutes | seconds | milliseconds
        0     | 1       | 1       | 61000
    }
}
