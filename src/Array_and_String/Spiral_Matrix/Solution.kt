package Array_and_String.Spiral_Matrix

//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
class Solution {
    enum class Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val height = matrix.size
        if (height == 0) return listOf()
        val width = matrix[0].size
        if (width == 0) return listOf()
        val matrixSize = width * height

        var leftBoundary = 0
        var rightBoundary = width - 1
        var topBoundary = 0
        var bottomBoundary = height - 1

        val result = arrayListOf<Int>()
        var index = 0
        var x = 0
        var y = 0
        var direction = Direction.RIGHT

        while (index < matrixSize) {
            result += matrix[y][x]
            index++
            when (direction) {
                Direction.UP -> if (y == topBoundary) {
                    x++
                    leftBoundary++
                    direction = Direction.RIGHT
                } else {
                    y--
                }
                Direction.DOWN -> if (y == bottomBoundary) {
                    x--
                    rightBoundary--
                    direction = Direction.LEFT
                } else {
                    y++
                }
                Direction.LEFT -> if (x == leftBoundary) {
                    y--
                    bottomBoundary--
                    direction = Direction.UP
                } else {
                    x--
                }
                Direction.RIGHT -> if (x == rightBoundary) {
                    y++
                    topBoundary++
                    direction = Direction.DOWN
                } else {
                    x++
                }
            }
        }

        return result
    }
}