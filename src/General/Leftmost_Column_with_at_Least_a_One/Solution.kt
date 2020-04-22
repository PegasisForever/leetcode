package General.Leftmost_Column_with_at_Least_a_One

interface BinaryMatrix {
    fun get(x: Int, y: Int): Int
    fun dimensions(): List<Int>
}

fun main() {
    Solution().leftMostColumnWithOne(object : BinaryMatrix {
        val array = arrayOf(arrayOf(0, 0, 0, 1))
        override fun dimensions() = listOf(array.size, array.first().size)
        override fun get(x: Int, y: Int) = array[x][y]
    })
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
class Solution {
    lateinit var matrix: BinaryMatrix
    lateinit var cache: IntArray
    var width = 0
    var height = 0

    fun leftMostColumnWithOne(matrix: BinaryMatrix): Int {
        matrix.dimensions().run {
            height = component1()
            width = component2()
        }
        this.matrix = matrix
        cache = IntArray(height) { -1 }

        var columnI = width - 1
        for (rowI in 0 until height) {
            columnI = binarySearch(rowI, columnI)
            if (columnI == 0) break
        }

        if (columnI == width - 1) {
            repeat(height) { y ->
                if (get(width - 1, y)) return columnI
            }
            return -1
        } else {
            return columnI
        }
    }

    fun get(x: Int, y: Int): Boolean {
        if (x == height - 1 && cache[y] != -1) return cache[y] == 1

        val value = matrix.get(y, x)
        if (x == height - 1) cache[y] = value
        return value == 1
    }

    fun binarySearch(rowI: Int, end: Int): Int {
        var left = 0
        var right = end
        while (left < right) {
            val mid = left + (right - left) / 2
            if (get(mid, rowI)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}