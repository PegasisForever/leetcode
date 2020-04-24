package Dynamic_Programming.Best_Time_to_Buy_and_Sell_Stock

fun main() {
    Solution().maxProfit(intArrayOf(7,1,5,3,6,4))
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var best = 0
        val dp = IntArray(prices.size) {0}
        for(i in 1 .. prices.lastIndex) {
            dp[i] = maxOf(dp[i-1] + prices[i] - prices[i-1], 0)
            if(dp[i] > best ) best = dp[i]
        }
        return best
    }
}