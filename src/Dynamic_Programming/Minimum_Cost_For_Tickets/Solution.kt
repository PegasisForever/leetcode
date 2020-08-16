package Dynamic_Programming.Minimum_Cost_For_Tickets

// https://leetcode.com/problems/minimum-cost-for-tickets/submissions/
class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val expandedDays = BooleanArray(365)
        days.forEach { day ->
            expandedDays[day - 1] = true
        }
        this.costs = costs
        this.cache = IntArray(366) { Int.MIN_VALUE }

        return dp(expandedDays.asList())
    }

    lateinit var costs: IntArray
    lateinit var cache: IntArray

    fun List<Boolean>.safeSubList(from: Int, to: Int): List<Boolean> {
        if (from > to) return emptyList()
        return subList(from, to)
    }

    fun dp(days: List<Boolean>): Int {
        if (days.isEmpty()) return 0
        if (cache[days.size] != Int.MIN_VALUE) return cache[days.size]
        val nextTrainDay = days.indexOfFirst { it }
        if (nextTrainDay == -1) return 0.also { cache[days.size] = it }
        return minOf(
            dp(days.safeSubList(nextTrainDay + 30, days.size)) + costs[2],
            dp(days.safeSubList(nextTrainDay + 7, days.size)) + costs[1],
            dp(days.safeSubList(nextTrainDay + 1, days.size)) + costs[0]
        ).also { cache[days.size] = it }
    }
}
