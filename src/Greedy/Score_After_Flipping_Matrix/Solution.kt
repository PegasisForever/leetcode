package Greedy.Score_After_Flipping_Matrix

// https://leetcode.com/problems/score-after-flipping-matrix/
class Solution {
    fun matrixScore(matrix: Array<IntArray>): Int {
        matrix.forEach { row ->
            if (row[0] == 0) {
                for (i in row.indices) {
                    row[i] = row[i] xor 1
                }
            }
        }

        for (cI in 1..matrix[0].lastIndex) {
            var ones = 0
            for (rI in matrix.indices) {
                ones += matrix[rI][cI]
            }
            if (ones * 2 < matrix.size) {
                for (rI in matrix.indices) {
                    matrix[rI][cI] = matrix[rI][cI] xor 1
                }
            }
        }

        return matrix.sumBy { row ->
            var sum = 0
            var unit = 1
            row.asList().asReversed().forEach { b ->
                sum += b * unit
                unit *= 2
            }
            sum
        }
    }
}