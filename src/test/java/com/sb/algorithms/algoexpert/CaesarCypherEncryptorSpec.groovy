package com.sb.algorithms.algoexpert

import spock.lang.Specification

class CaesarCypherEncryptorSpec extends Specification {

    def 'should shift every letter by key positions'() {
        expect:
        CaesarCypherEncryptor.caesarCypherEncryptor(inputString, inputKey) == result

        where:
        inputString | inputKey || result
        "a"         | 0        || "a"
        "a"         | 1        || "b"
        "aa"        | 1        || "bb"
        "aa"        | 0        || "aa"
        "xyz"       | 2        || "zab"
        "abc"       | 26       || "abc"
        "abc"       | 52       || "abc"
        "abc"       | 57       || "fgh"
    }
}
