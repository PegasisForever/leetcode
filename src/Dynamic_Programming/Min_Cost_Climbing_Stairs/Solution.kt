package Dynamic_Programming.Min_Cost_Climbing_Stairs

//https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        this.cost = cost
        memo = IntArray(cost.size) { -1 }
        targetI = cost.size
        return minOf(step(0), step(1))
    }

    lateinit var cost: IntArray
    var targetI = 0
    lateinit var memo: IntArray

    fun step(i: Int): Int {
        if (i >= targetI) return 0
        if (memo[i] != -1) return memo[i]
        val result = minOf(step(i + 1), step(i + 2)) + cost[i]
        memo[i] = result
        return result
    }
}
