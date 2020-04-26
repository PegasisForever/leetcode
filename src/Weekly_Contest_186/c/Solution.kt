package Weekly_Contest_186.c

fun main() {
    Solution().findDiagonalOrder(
        listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )
    )
}

//https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
//timeout
class Solution {
    var height = 0
    var width = 0

    fun List<List<Int>>.safeGet(x: Int, y: Int): Int? {
        val row = this[y]
        return if (x <= row.lastIndex) row[x] else null
    }

    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        height = nums.size
        width = nums.maxBy { it.size }!!.size
        if (height == 1) {
            return nums[0].toIntArray()
        }
        if (width == 1) {
            nums.map { it[0] }.toIntArray()
        }

        val result = arrayListOf<Int>()
        repeat(height) { y ->
            addToList(nums, 0, y, result)
        }
        repeat(width) { x ->
            if (x == 0) return@repeat
            addToList(nums, x, height - 1, result)
        }
        return result.toIntArray()
    }

    fun addToList(nums: List<List<Int>>, x: Int, y: Int, list: ArrayList<Int>) {
        var x = x
        var y = y

        while (x < width && y >= 0) {
            val num = nums.safeGet(x, y)
            println("$x $y")
            if (num != null) {
                println("add $num")
                list.add(num)
            }
            x++
            y--
        }
    }
}