package General.Best_Time_to_Buy_and_Sell_Stock_2

fun main() {
    val data = arrayOf(
        intArrayOf(7, 1, 5, 3, 6, 4)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.maxProfit(d))
    }
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var lastBuy = Int.MAX_VALUE

        prices.forEach { price ->
            if (price > lastBuy) {
                profit += price - lastBuy
            }
            lastBuy = price
        }

        return profit
    }
}