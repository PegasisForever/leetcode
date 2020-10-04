package Dynamic_Programming.Longest_Arithmetic_Subsequence

import println

fun main() {
    Solution().longestArithSeqLength(intArrayOf(83, 20, 17, 43, 52, 78, 68, 45)).println()
}

// https://leetcode.com/problems/longest-arithmetic-subsequence/
class Solution {
    fun longestArithSeqLength(arr: IntArray): Int {
        this.arr = arr

        var max = 0
        for (i in 0 until arr.lastIndex) {
            for (j in (i + 1)..arr.lastIndex) {
                max = maxOf(max, step(i, arr[j] - arr[i]) + 1)
            }
        }
        return max
    }

    lateinit var arr: IntArray
    val cache = Array(1001) { IntArray(1001) { -1 } }

    fun step(startI: Int, interval: Int): Int {
        if (startI >= arr.lastIndex) return 0

        val intervalIndex = interval + 500
        if (cache[startI][intervalIndex] != -1) return cache[startI][intervalIndex]

        var i = startI + 1
        var max = 0
        while (i < arr.size) {
            if (arr[i] - arr[startI] == interval) {
                max = maxOf(max, 1 + step(i, interval))
            }
            i++
        }

        cache[startI][intervalIndex] = max
        return max
    }
}
