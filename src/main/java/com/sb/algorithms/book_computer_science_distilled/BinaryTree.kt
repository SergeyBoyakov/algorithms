package com.sb.algorithms.book_computer_science_distilled

import java.util.*
import kotlin.collections.HashSet

class BinaryTree(var root: Node?)

data class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
    val connectedNodes = listOf(left, right)
}

fun findNode(tree: BinaryTree, value: Int): Node? {
    var currentNode = tree.root
    while (true) {
        if (currentNode?.value == value)
            return currentNode

        if (currentNode?.left == null && currentNode?.right == null)
            return null

        currentNode = if (currentNode.value > value)
            currentNode.left
        else
            currentNode.right
    }
}

fun insertNode(tree: BinaryTree, newNode: Node) {
    var currentNode = tree.root

    while (true) {
        if (currentNode?.value == newNode.value) {
            return
        }

        if (currentNode?.value!! > newNode.value) {
            currentNode = currentNode.left
        }
        if (currentNode?.value!! < newNode.value) {
            currentNode = currentNode?.right
        }

        if (currentNode?.left == null && currentNode?.right == null) {
            if (newNode.value > currentNode?.value!!) {
                currentNode?.right = newNode
                return
            }

            if (newNode.value < currentNode?.value!!) {
                currentNode?.left = newNode
                return
            }
        }
    }
}

// Depth first search
fun dfs(startNode: Node, value: Any): Node? {
    val nextNodes = Stack<Node>()
    val seenNodes = HashSet<Node>()

    nextNodes.push(startNode)
    seenNodes.add(startNode)

    while (nextNodes.isNotEmpty()) {
        val node = nextNodes.pop()

        if (node.value == value)
            return node

        node.connectedNodes
            .filterNotNull()
            .filter { !seenNodes.contains(it) }
            .forEach {
                nextNodes.push(it)
                seenNodes.add(it)
            }
    }

    return null
}

// Breadth first search
fun bfs(startNode: Node, value: Any): Node? {
    val nextNodes: Queue<Node> = LinkedList()
    val seenNodes = HashSet<Node>()

    nextNodes.add(startNode)
    seenNodes.add(startNode)

    while (nextNodes.isNotEmpty()) {
        var node = nextNodes.remove()

        if (node.value == value)
            return node

        node.connectedNodes
            .filterNotNull()
            .filter { !seenNodes.contains(it) }
            .forEach {
                nextNodes.add(it)
                seenNodes.add(it)
            }

    }

    return null
}




