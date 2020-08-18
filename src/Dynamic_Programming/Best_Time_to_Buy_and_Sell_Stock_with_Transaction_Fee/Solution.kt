package Dynamic_Programming.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee

import kotlin.properties.Delegates

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
// TODO
class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        this.fee = fee
        this.prices = prices

        if (prices.isEmpty()) return 0
        return dp(0, 0).coerceAtLeast(0)
    }

    var cache = hashMapOf<Long, Int>()
    var fee by Delegates.notNull<Int>()
    lateinit var prices: IntArray

    fun dp(i: Int, brought: Int): Int {
        if (i == prices.lastIndex) {
            return if (brought != 0) {
                prices[i] - brought
            } else {
                0
            }
        }

        val cached = cache[(i.toLong() shl 16) + brought]
        if (cached != null) return cached

        return if (brought == 0) {
            maxOf(
                dp(i + 1, 0),
                dp(i + 1, prices[i]) - fee
            )
        } else {
            maxOf(
                dp(i + 1, brought),
                dp(i + 1, 0) + (prices[i] - brought)
            )
        }.also { cache[(i.toLong() shl 16) + brought] = it }
    }
}
