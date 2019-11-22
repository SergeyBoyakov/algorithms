package com.sb.algorithms.leetcode

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.tableOf
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumberOfIslandsKt {
    fun numberOfIslands(grid: Array<CharArray>): Int {
        var numberOfIslands = 0;
        for (i in 0..grid.lastIndex)
            for (j in 0..grid[i].lastIndex) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j)
                    numberOfIslands++
                }
            }

        return numberOfIslands
    }

    private fun bfs(grid: Array<CharArray>, i: Int, j: Int) {
        if (grid.size == 0 || grid[i].size == 0)
            return
        if (grid[i][j] == '0')
            return

        grid[i][j] = '0'

        if (i > 0)
            bfs(grid, i - 1, j)
        if (j > 0)
            bfs(grid, i, j - 1)
        if (i < grid.lastIndex)
            bfs(grid, i + 1, j)
        if (j < grid[i].lastIndex)
            bfs(grid, i, j + 1)
    }
}

class NumberOfIslandsKtTest {
    private lateinit var numberOfIslands: NumberOfIslandsKt

    @BeforeEach
    fun init() {
        numberOfIslands = NumberOfIslandsKt()
    }

    @Test
    fun `should calculate number of islands`() {
        tableOf("grid", "result")
            .row(arrayOf(charArrayOf()), 0)
            .row(arrayOf(charArrayOf('1')), 1)
            .row(arrayOf(charArrayOf('1', '0', '1')), 2)
            .row(arrayOf(charArrayOf('1', '1', '0')), 1)
            .row(
                arrayOf(
                    charArrayOf('1', '1', '0'),
                    charArrayOf('1', '0', '1')
                ), 2
            )
            .row(
                arrayOf(
                    charArrayOf('0', '0', '0'),
                    charArrayOf('0', '1', '0'),
                    charArrayOf('0', '0', '0')
                ), 1
            )
            .row(
                arrayOf(
                    charArrayOf('1', '0', '0'),
                    charArrayOf('0', '1', '0'),
                    charArrayOf('0', '0', '1')
                ), 3
            )
            .row(
                arrayOf(
                    charArrayOf('1', '0', '0'),
                    charArrayOf('1', '1', '0'),
                    charArrayOf('0', '0', '1')
                ), 2
            )
            .row(
                arrayOf(
                    charArrayOf('1'),
                    charArrayOf('1'),
                    charArrayOf('0')
                ), 1
            )
            .forAll { grid, result ->
                assertThat(numberOfIslands.numberOfIslands(grid)).isEqualTo(result)
            }
    }
}
