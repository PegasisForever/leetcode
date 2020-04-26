package Dynamic_Programming.Matrix_Block_Sum

fun main() {
    Solution().matrixBlockSum(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    ),1)
}

//https://leetcode.com/problems/matrix-block-sum/submissions/
class Solution {
    fun Array<IntArray>.safeGet(x: Int, y: Int): Int {
        if (x < 0 || x >= width || y < 0 || y >= height) return 0
        return this[y][x]
    }

    var width = 0
    var height = 0

    fun matrixBlockSum(matrix: Array<IntArray>, k: Int): Array<IntArray> {
        height = matrix.size
        width = matrix.first().size
        val result = Array(height) { IntArray(width) }

        var sum = 0
        for (x in 0..k) for (y in 0..k) {
            sum += matrix.safeGet(x, y)
        }
        result[0][0] = sum

        var y = 0

        while (true) {
            for (x in 1 until width) {
                val removeCX = x - k - 1
                val addCX = x + k
                for (yy in y - k..y + k) {
                    sum += matrix.safeGet(addCX, yy) - matrix.safeGet(removeCX, yy)
                }
                result[y][x] = sum
            }
            if (y == height - 1) break
            for (xx in width - 1 - k..width - 1 + k) {
                sum += matrix.safeGet(xx, y + k + 1) - matrix.safeGet(xx, y - k)
            }
            result[y + 1][width - 1] = sum
            y++


            for (x in width - 2 downTo 0) {
                val removeCX = x + k +1
                val addCX = x - k
                for (yy in y - k..y + k) {
                    sum += matrix.safeGet(addCX, yy) - matrix.safeGet(removeCX, yy)
                }
                result[y][x] = sum
            }
            if (y == height - 1) break
            for (xx in -k..k) {
                sum += matrix.safeGet(xx, y + k + 1) - matrix.safeGet(xx, y - k)
            }
            result[y + 1][0] = sum
            y++
        }

        return result
    }
}