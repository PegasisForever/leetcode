package Binary_Search.Search_for_a_Range

fun main() {
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 5).joinToString())
}

//https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
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

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val startIndex = binaryFindFirst(0, nums.lastIndex) { i ->
            nums[i] >= target
        } ?: -1
        if (startIndex == -1 || nums[startIndex] != target) return intArrayOf(-1, -1)

        val endIndex = binaryFindFirst(startIndex, nums.lastIndex) { i ->
            nums[i] != target
        }?.minus(1) ?: nums.lastIndex

        return intArrayOf(startIndex, endIndex)
    }
}
