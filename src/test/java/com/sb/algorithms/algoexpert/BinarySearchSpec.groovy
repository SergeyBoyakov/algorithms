package com.sb.algorithms.algoexpert

import spock.lang.Specification

class BinarySearchSpec extends Specification {

    def 'binarySearch'() {
        expect:
        BinarySearch.binarySearch(arr, target) == result

        where:
        arr                      | target | result
        [1] as int[]             | 1      | 0
        [1] as int[]             | 2      | -1
        [1, 2, 3] as int[]       | 1      | 0
        [1, 5, 23, 111] as int[] | 111    | 3
        [1, 5, 23, 111] as int[] | 5      | 1
        [1, 5, 23, 111] as int[] | 35     | -1
    }
}
