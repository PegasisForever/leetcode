package Weekly_Contest_180.Lucky_Numbers_in_a_Matrix

//https://leetcode.com/contest/weekly-contest-180/problems/lucky-numbers-in-a-matrix/
class Solution {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val height = matrix.size
        val result = arrayListOf<Int>()

        fun maxInColumn(columnI: Int, num: Int): Boolean {
            repeat(height) { i ->
                if (num < matrix[i][columnI]) return false
            }
            return true
        }

        matrix.forEach { row ->
            val (columnI, min) = row.minIndexed()
            if (maxInColumn(columnI, min)) {
                result += min
            }
        }

        return result
    }

    fun IntArray.minIndexed(): Pair<Int, Int> {
        var min = Int.MAX_VALUE
        var i = 0
        forEachIndexed { index, num ->
            if (num < min) {
                min = num
                i = index
            }
        }
        return i to min
    }
}