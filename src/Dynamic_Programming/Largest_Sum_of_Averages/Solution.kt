package Dynamic_Programming.Largest_Sum_of_Averages

import println

fun main() {
    Solution().largestSumOfAverages(intArrayOf(9, 9), 2).println()
}

// https://leetcode.com/problems/largest-sum-of-averages/
class Solution {
    fun largestSumOfAverages(arr: IntArray, k: Int): Double {
        cache = Array(arr.size) { DoubleArray(k + 1) { Double.NaN } }
        this.arr = arr
        return step(0, k)
    }

    lateinit var arr: IntArray
    lateinit var cache: Array<DoubleArray>

    fun step(i: Int, k: Int): Double {
        if (!cache[i][k].isNaN()) return cache[i][k]

        return if (k == 1) {
            avgOf(i..arr.lastIndex)
        } else {
            var max = 0.0
            var sum = 0.0
            var count = 0
            for (nextI in (i + 1)..(arr.size - k + 1)) {
                sum += arr[nextI - 1]
                count++
                max = maxOf(max, sum / count + step(nextI, k - 1))
            }
            max
        }.also {
            cache[i][k] = it
        }
    }

    fun avgOf(range: IntRange): Double {
        var total = 0.0
        for (i in range) {
            total += arr[i]
        }
        return total / (range.last - range.first + 1)
    }
}
