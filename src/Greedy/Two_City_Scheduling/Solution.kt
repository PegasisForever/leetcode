package Greedy.Two_City_Scheduling

// https://leetcode.com/problems/two-city-scheduling/
class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortBy { (a, b) -> a - b }

        var cost = 0
        for (i in 0 until (costs.size / 2)) {
            cost += costs[i][0]
        }
        for (i in (costs.size / 2) until costs.size) {
            cost += costs[i][1]
        }
        return cost
    }
}
