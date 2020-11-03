package com.sb.algorithms.algoexpert;


import javax.swing.plaf.basic.BasicArrowButton;
import java.util.*;

class DepthFirstSearch {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            return this.depthFirstSearch(array, this);
//            Stack<Node> connectedNodes = new Stack<>();
//            Set<Node> seenNode = new HashSet<>();
//            connectedNodes.push(this);
//            seenNode.add(this);
//
//            while (!connectedNodes.isEmpty()) {
//                Node node = connectedNodes.pop();
//
//                array.add(node.name);
//
//                node.children.stream()
//                        .filter(element -> element != null)
//                        .filter(element -> !seenNode.contains(element))
//                        .forEach(element -> {
//                            connectedNodes.push(element);
//                            seenNode.add(element);
//                        });
//            }

            // Write your code here.
//            return null;
        }

        private List<String> depthFirstSearch(List<String> array, Node self) {
            array.add(self.name);
            for (Node node : self.children) {
                node.depthFirstSearch(array, node);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

