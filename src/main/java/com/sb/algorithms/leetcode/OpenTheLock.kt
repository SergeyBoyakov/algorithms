package com.sb.algorithms.leetcode

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.tableOf
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OpenTheLock {
    /*
    https://leetcode.com/problems/open-the-lock/
    Medium
    You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
    The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
    Each move consists of turning one wheel one slot.

    The lock initially starts at '0000', a string representing the state of the 4 wheels.

    You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
    the wheels of the lock will stop turning and you will be unable to open it.

    Given a target representing the value of the wheels that will unlock the lock,
    return the minimum total number of turns required to open the lock, or -1 if it is impossible.
     */
    fun openLock(deadends: Array<String>,
                 target  : String       ): Int {
        var ticks = 0

        if (deadends.any { it.matches(Regex("[0]+")) })
            return -1

        for (num in target) {
            val value = num.toString().toInt()
            // TODO if
            ticks += if (value < 6) {
                value
            } else
                (10 - value)
        }

        return ticks
    }
}

//fun main() {
//    val boo = "000"
//    println(boo.matches(Regex("[0]+")))
//}

class OpenTheLockTest {
    private lateinit var openTheLock: OpenTheLock

    @BeforeEach
    fun init() {
        openTheLock = OpenTheLock()
    }

    @Test
    fun `should return minimum total number of turns required to open the lock`() {
        tableOf("deadEnds", "target", "result")
            .row(arrayOf("0"), "8", -1)
            .row(arrayOf(""), "8", 2)
            .row(arrayOf("8888"), "0009", 1)
            .row(arrayOf("0201","0101","0102","1212","2002"), "0202", 6)
//            .row(arrayOf("8887","8889","8878","8898","8788","8988","7888","9888"), "8888", -)


            .forAll { deadEnds, target, result ->
                assertThat(openTheLock.openLock(deadEnds, target)).isEqualTo(result)
            }
    }
}