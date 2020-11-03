package com.sb.algorithms.book_computer_science_distilled

// Kayden Algorithm
/*
* Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
* E.g. we have prices of S&P500 in different days. [100, 99,102,80,118]. We should find best day to buy and best day to sell for
* maximum profit.
* Book: Computer science distilled page 222
*/

// return pair sell_day : buy_day
fun tradeKadane(prices: List<Int>): Pair<Int, Int> {
    var sellDay = 1
    var buyDay = 1
    var bestProfit = 0
    for (s in 2..prices.lastIndex) {
        val b = if (prices[s] < prices[buyDay]) s else buyDay
        val profit = prices[s] - prices[b]
        if (profit > bestProfit) {
            sellDay = s
            buyDay = b
            bestProfit = profit
        }
    }

    return Pair(sellDay, buyDay)
}
