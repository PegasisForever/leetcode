package Weekly_Contest_202.c

fun main() {
    Solution().maxDistance(
        intArrayOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        ), 4
    )
}

// TODO
// https://leetcode.com/contest/weekly-contest-202/problems/magnetic-force-between-two-balls/
class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        this.position = position.sortedArray()
        cache = Array(position.size + 1) { IntArray(m + 1) { Int.MIN_VALUE } }

        return dp(0, m, null)
    }

    lateinit var position: IntArray
    lateinit var cache: Array<IntArray>

    fun dp(i: Int, m: Int, lastI: Int?): Int {
        if (m == 1) {
            return position.last() - position[lastI!!]
        }
        if (position.size - i < m || i > position.lastIndex) return Int.MIN_VALUE
        if (cache[i][m] != Int.MIN_VALUE) return cache[i][m]

        return maxOf(
            if (lastI != null) {
                minOf(dp(i + 1, m - 1, i), position[i] - position[lastI])
            } else {
                dp(i + 1, m - 1, i)
            },
            dp(i + 1, m, lastI)
        ).also { cache[i][m] = it }
    }
}
