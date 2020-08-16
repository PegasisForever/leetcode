package Dynamic_Programming.Minimum_ASCII_Delete_Sum_for_Two_Strings

// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/submissions/
class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        cache = Array(s1.length + 1) { IntArray(s2.length + 1) { Int.MIN_VALUE } }
        this.s1 = s1
        this.s2 = s2

        cache[s1.length][s2.length] = 0
        for (i in s1.lastIndex downTo 0) {
            cache[i][s2.length] = cache[i + 1][s2.length] + s1[i].toInt()
        }
        for (j in s2.lastIndex downTo 0) {
            cache[s1.length][j] = cache[s1.length][j + 1] + s2[j].toInt()
        }

        return dp(0, 0)
    }

    lateinit var cache: Array<IntArray>
    lateinit var s1: String
    lateinit var s2: String

    fun dp(i: Int, j: Int): Int {
        if (cache[i][j] != Int.MIN_VALUE) return cache[i][j]

        return if (s1[i] == s2[j]) {
            dp(i + 1, j + 1)
        } else {
            minOf(
                dp(i, j + 1) + s2[j].toInt(),
                dp(i + 1, j) + s1[i].toInt()
            )
        }.also { cache[i][j] = it }
    }
}
