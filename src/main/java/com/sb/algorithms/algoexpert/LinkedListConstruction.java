package com.sb.algorithms.algoexpert;

public class LinkedListConstruction {
    // Feel free to add new properties and methods to the class.
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            this.head = node;
        }

        public void setTail(Node node) {
            // Write your code here.
            this.tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {

            if (node != null && nodeToInsert != null) {
                nodeToInsert.prev = node.prev;
                nodeToInsert.next = node;

                node.prev.next = nodeToInsert;
                node.prev = nodeToInsert;
            }

            // Write your code here.
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (node != null && nodeToInsert != null) {
                nodeToInsert.prev = node;
                nodeToInsert.next = node.next;

                node.next.prev = nodeToInsert;
                node.next = nodeToInsert;
            }
            // Write your code here.
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (nodeToInsert == null) return;

            int counter = 0;
            Node node = head;
            while (counter < position) {
                counter++;
            }
            // Write your code here.
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            // Write your code here.
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.

            return false;
        }

        public Node findNodeWithValue(final int value) {
            return iter(this.head, value);
        }

        private Node iter(final Node node, final int value) {
            if (node.value == value) return node;
            if (node.next != null) return iter(node.next, value);

            return null;
        }

    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}


