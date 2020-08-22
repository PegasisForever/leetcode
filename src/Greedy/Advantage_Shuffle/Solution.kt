package Greedy.Advantage_Shuffle

// https://leetcode.com/problems/advantage-shuffle/
class Solution {
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

    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val result = IntArray(A.size)
        val arr = A.sorted().toMutableList()
        var arrStart = 0

        B.forEachIndexed { i, b ->
            val aI = binaryFindFirst(arrStart, arr.lastIndex) { aI ->
                arr[aI] > b
            }
            if (aI != null) {
                result[i] = arr[aI]
                arr.removeAt(aI)
            } else {
                result[i] = arr[arrStart]
                arrStart++
            }
        }

        return result
    }
}
