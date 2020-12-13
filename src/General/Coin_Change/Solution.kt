package General.Coin_Change

// https://leetcode.com/problems/coin-change/
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        cache = IntArray(amount + 1) { -1 }
        this.coins = coins

        val result = step(amount)
        return if (result == Int.MAX_VALUE) {
            -1
        } else {
            result
        }
    }

    lateinit var coins: IntArray
    lateinit var cache: IntArray

    fun step(amount: Int): Int {
        if (amount == 0) return 0
        if (cache[amount] != -1) return cache[amount]
        var min = Int.MAX_VALUE
        for (coin in coins) {
            val before = amount - coin
            if (before >= 0) {
                val stepBefore = step(before)
                if (stepBefore != Int.MAX_VALUE) {
                    min = minOf(min, stepBefore + 1)
                }
            }
        }

        cache[amount] = min
        return min
    }
}
