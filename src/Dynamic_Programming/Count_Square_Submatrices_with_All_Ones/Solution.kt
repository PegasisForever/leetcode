package Dynamic_Programming.Count_Square_Submatrices_with_All_Ones

fun main() {
    println(
        Solution().countSquares(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 1, 1)
            )
        )
    )
}

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val M: Int = matrix.size
        val N: Int = matrix[0].size
        var ans = 0

        val dp = Array(M + 1) { IntArray(N + 1) }

        for (i in 1..M) {
            for (j in 1..N) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + minOf(
                        dp[i - 1][j],
                        dp[i][j - 1],
                        dp[i - 1][j - 1]
                    )
                    ans += dp[i][j]
                }
            }
        }
        return ans
    }
}
