package com.sb.algorithms.algoexpert

import spock.lang.Specification

class LongestPalindromicStringSpec extends Specification {

    def 'commonTest'() {
        expect:
        LongestPalindromicString.longestPalindromicSubstring(input) == result

        where:
        input                               | result
        "a"                                 | "a"
        "it's highnoon"                     | "noon"
        "noon high it is"                   | "noon"
        "abccbait's highnoon"               | "abccba"
        "abaxyzzyxf"                        | "xyzzyx"
        "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz" | "zzzzzzzzzzzzzzzzzzzz"
        "abcdefgfedcba"                     | "abcdefgfedcba"
        "abcdefghfedcbaa"                   | "aa"
        "abcdefggfedcba"                    | "abcdefggfedcba"
        "zzzzzzz2345abbbba5432zzbbababa"    | "zz2345abbbba5432zz"
        "z234a5abbbba54a32z"                | "5abbbba5"
        "z234a5abbba54a32z"                 | "5abbba5"
    }
}
