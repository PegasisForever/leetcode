package Weekly_contest_209.Special_Array_With_X_Elements_Greater_Than_or_Equal_X

import println

fun main() {
    Solution().specialArray(
        intArrayOf(
            3, 6, 7, 7, 0
        )
    ).println()
}

// https://leetcode.com/contest/weekly-contest-209/problems/special-array-with-x-elements-greater-than-or-equal-x/
class Solution {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        if (nums.size <= nums[0]) return nums.size
        for (i in 0..(nums.size - 2)) {
            val range = nums[i]..nums[i + 1]
            val gOrECount = nums.size - i - 1
            if (gOrECount in range) return gOrECount
        }
        return -1
    }
}
