package Dynamic_Programming.Paint_House

//https://leetcode.com/problems/paint-house/submissions/
class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        return step(-1, costs.asList())
    }

    val memo = hashMapOf<Pair<Int, Int>, Int>()

    fun step(pervColor: Int, costs: List<IntArray>): Int {
        if (costs.isEmpty()) return 0
        val pair = pervColor to costs.size
        if (pair in memo) return memo[pair]!!

        var min = Int.MAX_VALUE
        repeat(3) { color ->
            if (color != pervColor) {
                min = minOf(min, step(color, costs.subList(1, costs.size)) + costs.first()[color])
            }
        }
        memo[pair] = min
        return min
    }
}