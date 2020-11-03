package com.sb.algorithms.algoexpert

import spock.lang.Specification

class ThreeNumberSumSpec extends Specification {

    def 'test1'() {
        expect:
        ThreeNumberSum.threeNumberSum(arr as int[], targetSum) == result

        where:
        arr                                | targetSum || result
        [1, 2, 3]                          | 6         || [[1, 2, 3]]
        [1, 2, 3]                          | 7         || []
        [8, 10, -2, 49, 14]                | 57        || [[-2, 10, 49]]
        [12, 3, 1, 2, -6, 5, -8, 6]        | 0         || [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
        [12, 3, 1, 2, -6, 5, 0, -8, -1]    | 0         || [[-8, 3, 5], [-6, 1, 5], [-1, 0, 1]]
        [12, 3, 1, 2, -6, 5, 0, -8, -1, 6] | 0         || [[-8, 2, 6], [-8, 3, 5], [-6, 0, 6], [-6, 1, 5], [-1, 0, 1]]
    }
}
