package Weekly_Contest_180.Maximum_Performance_of_a_Team

import kotlin.math.min

fun main() {
    val s = Solution()
    s.maxPerformance(
        6,
        intArrayOf(10, 5, 1, 7, 4, 2),
        intArrayOf(2, 1, 1, 1, 7, 3),
        6
    )
}

//https://leetcode.com/contest/weekly-contest-180/problems/maximum-performance-of-a-team/
//incorrect
class Solution {
    val M = 1000000007
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        var speedSum: Long = 0
        var effiMin: Long = Long.MAX_VALUE
        val selected = hashSetOf<Int>()
        for (j in 0 until k) {
            var bestNewSpeed = speedSum
            var bestNewEffi = effiMin
            var bestI = -1
            repeat(n) i@{ i ->
                if (i in selected) return@i
                val newSpeed = speedSum + speed[i]
                val newEffi = min(effiMin, efficiency[i].toLong())
                if (newSpeed * newEffi > bestNewSpeed * bestNewEffi) {
                    bestNewSpeed = newSpeed
                    bestNewEffi = newEffi
                    bestI = i
                }
            }

            if (bestI != -1) {
                selected += bestI
                speedSum = bestNewSpeed
                effiMin = bestNewEffi
            } else {
                break
            }
        }
        return ((speedSum * effiMin) % M).toInt()
    }
}