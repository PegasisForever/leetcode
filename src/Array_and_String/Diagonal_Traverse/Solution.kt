package Array_and_String.Diagonal_Traverse

//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
class Solution {
    enum class Direction {
        UPRIGHT,
        DOWNLEFT
    }

    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        val height = matrix.size
        if (height == 0) return intArrayOf()
        val width = matrix[0].size
        if (width == 0) return intArrayOf()

        val result = IntArray(width * height)
        var index = 0
        var x = 0
        var y = 0
        var direction = Direction.UPRIGHT

        while (index < result.size) {
            result[index] = matrix[y][x]
            index++
            if (direction == Direction.UPRIGHT) {
                if (x == width - 1) {
                    y++
                    direction = Direction.DOWNLEFT
                } else if (y == 0) {
                    x++
                    direction = Direction.DOWNLEFT
                } else {
                    x++
                    y--
                }
            } else {
                if (y == height - 1) {
                    x++
                    direction = Direction.UPRIGHT
                } else if (x == 0) {
                    y++
                    direction = Direction.UPRIGHT
                } else {
                    x--
                    y++
                }
            }
        }
        return result
    }
}