package com.sb.algorithms.algoexpert

import spock.lang.Specification


class GroupAnagramsSpec extends Specification {

    def 'should group'() {
        expect:
        GroupAnagrams.groupAnagrams(input) == output

        where:
        input              | output
        ["ab", "ba"]       | [["ab", "ba"]]
        ["ab", "cc", "ba"] | [["cc"], ["ab", "ba"]]
    }
}
