package Weekly_Contest_213.Furthest_Building_You_Can_Reach

import println


fun main() {
    Solution().furthestBuilding(intArrayOf(1,2), 5, 0).println()
}

// https://leetcode.com/contest/weekly-contest-213/problems/furthest-building-you-can-reach/
class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val heightsDiff = IntArray(heights.size - 1).toMutableList()
        for (i in 0 until heights.lastIndex) {
            heightsDiff[i] = heights[i + 1] - heights[i]
        }

        return binaryFindFirst(0, heightsDiff.lastIndex) { i ->
            val heightsDiff = heightsDiff.subList(0, i + 1)
            heightsDiff.sort()

            var bricksLeft = bricks
            var laddersLeft = ladders
            for (heightDiff in heightsDiff) {
                if (heightDiff > 0) {
                    if (bricksLeft >= heightDiff) {
                        bricksLeft -= heightDiff
                    } else if (laddersLeft > 0) {
                        laddersLeft--
                    } else {
                        return@binaryFindFirst true
                    }
                }
            }

            return@binaryFindFirst false
        } ?: heights.lastIndex
    }

    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid: Int
        while (left < right) {
            mid = left + (right - left) / 2
            if (action(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == to) {
            if (action(to)) {
                to
            } else {
                null
            }
        } else {
            left
        }
    }
}
