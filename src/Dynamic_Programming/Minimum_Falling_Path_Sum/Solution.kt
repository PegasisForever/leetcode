package Dynamic_Programming.Minimum_Falling_Path_Sum

// https://leetcode.com/problems/minimum-falling-path-sum/submissions/
class Solution {
    fun minFallingPathSum(arr: Array<IntArray>): Int {
        this.cache = Array(arr.size) { IntArray(arr.size) { Int.MIN_VALUE } }
        this.arr = arr

        return arr.indices.map { j ->
            dp(0, j)
        }.min()!!
    }

    lateinit var cache: Array<IntArray>
    lateinit var arr: Array<IntArray>

    fun dp(i: Int, j: Int): Int {
        if (j < 0 || j > arr.lastIndex) return 100000
        if (cache[i][j] != Int.MIN_VALUE) return cache[i][j]
        if (i == cache.lastIndex) return arr[i][j]

        return minOf(
            arr[i][j] + dp(i + 1, j - 1),
            arr[i][j] + dp(i + 1, j),
            arr[i][j] + dp(i + 1, j + 1)
        ).also { cache[i][j] = it }
    }
}
