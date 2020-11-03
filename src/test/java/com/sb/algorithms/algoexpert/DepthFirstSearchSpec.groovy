package com.sb.algorithms.algoexpert

import spock.lang.Specification

class DepthFirstSearchSpec extends Specification {
    DepthFirstSearch depthFirstSearch

    def setup() {
        depthFirstSearch = new DepthFirstSearch()
    }

    def 'should'() {
        expect:
        DepthFirstSearch.Node.depthFirstSearch(new ArrayList<String>())



    }

}
