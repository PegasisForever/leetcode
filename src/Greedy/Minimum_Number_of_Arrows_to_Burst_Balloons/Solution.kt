package Greedy.Minimum_Number_of_Arrows_to_Burst_Balloons

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        val p = points.toMutableList()

        var count = 0
        while (p.isNotEmpty()) {
            val x = p.first()[1]
            count++

            p.removeAt(0)
            p.removeIf { (start, end) -> x in start..end }
        }
        return count
    }
}
