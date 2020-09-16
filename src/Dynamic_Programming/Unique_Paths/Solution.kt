package Dynamic_Programming.Unique_Paths

import println

fun main() {
    Solution().uniquePaths(7, 3).println()
}

// https://leetcode.com/problems/unique-paths/
class Solution {
    val cache = Array(101) { IntArray(101) { -1 } }

    // m<=n
    fun uniquePaths(m: Int, n: Int): Int {
        var m = m
        var n = n
        if (m > n) {
            val temp = n
            n = m
            m = temp
        }

        if (m == 1) return 1
        if (cache[m][n] != -1) return cache[m][n]

        val sum = uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
        cache[m][n] = sum
        return sum
    }
}
