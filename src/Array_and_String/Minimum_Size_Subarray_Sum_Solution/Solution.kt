package Array_and_String.Minimum_Size_Subarray_Sum_Solution

import kotlin.math.min

fun main() {
    Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))
}

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var minLength = Int.MAX_VALUE
        var i = 0
        var j = 0
        var sum = nums[0]
        while (j < nums.size) {
            if (sum >= target) {
                minLength = min(minLength, j - i + 1)
                if (minLength == 1) return minLength
                i++
                sum -= nums[i - 1]
            } else {
                j++
                if (j < nums.size) sum += nums[j]
            }
        }

        if (sum >= target) minLength = min(minLength, j - i + 1)
        if (minLength == Int.MAX_VALUE) minLength = 0
        return minLength
    }
}