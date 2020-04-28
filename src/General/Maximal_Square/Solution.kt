package General.Maximal_Square

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val rows = matrix.size
        val cols = if (rows > 0) matrix[0].size else 0
        var maxsqlen = 0
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (matrix[i][j] == '1') {
                    var sqlen = 1
                    var flag = true
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (k in j..sqlen + j) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false
                                break
                            }
                        }
                        for (k in i..sqlen + i) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false
                                break
                            }
                        }
                        if (flag) sqlen++
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen
                    }
                }
            }
        }
        return maxsqlen * maxsqlen
    }
}