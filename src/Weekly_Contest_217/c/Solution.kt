package Weekly_Contest_217.c

import println

fun main() {
    Solution().minMoves(intArrayOf(1, 1, 1, 1), 1).println()
}

// https://leetcode.com/contest/weekly-contest-217/problems/minimum-moves-to-make-array-complementary/
class Solution {
    abstract class Point {
        open val value = 0
        open val lineI = 0

        fun getTypeNum() = when (this) {
            is StartPoint -> 0
            is MiddlePoint -> 1
            is EndPoint -> 2
            else -> error("")
        }
    }

    data class StartPoint(override val value: Int, override val lineI: Int) : Point()
    data class MiddlePoint(override val value: Int, override val lineI: Int) : Point()
    data class EndPoint(override val value: Int, override val lineI: Int) : Point()

    fun minMoves(nums: IntArray, limit: Int): Int {
        val points = ArrayList<Point>(nums.size / 2 * 3)
        for (i in 0 until nums.size / 2) {
            val min = minOf(nums[i], nums[nums.size - 1 - i])
            val max = maxOf(nums[i], nums[nums.size - 1 - i])
            val start = StartPoint(1 + min, i)
            val middle = MiddlePoint(min + max, i)
            val end = EndPoint(max + limit, i)

            points += start
            points += middle
            points += end
        }
        points.sortWith(Comparator { a, b ->
            if (a.value != b.value) {
                a.value.compareTo(b.value)
            } else {
                a.getTypeNum().compareTo(b.getTypeNum())
            }
        })

        var middleLinesCount = 0

        var moveCount = nums.size
        var minMoveCount = moveCount
        var lastPointValue = -1
        points.forEach { point ->
            if (lastPointValue != -1 && point.value != lastPointValue) {
                moveCount += middleLinesCount
                middleLinesCount = 0
            }
            lastPointValue = point.value

            when (point) {
                is StartPoint -> {
                    moveCount--
                }
                is MiddlePoint -> {
                    moveCount--
                    middleLinesCount++
                }
                is EndPoint -> {
                    moveCount++
                }
            }

            minMoveCount = minOf(minMoveCount, moveCount)
        }

        return minMoveCount
    }
}
