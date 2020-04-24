package Dynamic_Programming.House_Robber

//https://leetcode.com/problems/house-robber/
class Solution {
    fun rob(money: IntArray): Int {
        this.money = money
        memo = IntArray(money.size) { -1 }
        return step(false, 0)
    }

    lateinit var money: IntArray
    lateinit var memo: IntArray

    fun step(robbedLast: Boolean, i: Int): Int {
        if (i == money.size) return 0
        if (robbedLast) return step(false, i + 1)
        if (memo[i] != -1) return memo[i]

        return maxOf(
            step(true, i + 1) + money[i],
            step(false, i + 1)
        ).also { memo[i] = it }
    }
}