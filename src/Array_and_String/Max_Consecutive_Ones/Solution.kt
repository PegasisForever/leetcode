package Array_and_String.Max_Consecutive_Ones

import kotlin.math.max

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var maxLength = 0

        var slow = -1
        nums.forEachIndexed { i, num ->
            if (num == 1) {
                if (slow == -1) slow = i
            } else {
                if (slow != -1) {
                    maxLength = max(maxLength, i - slow)
                    slow = -1
                }
            }
        }

        if (slow != -1) {
            maxLength = max(maxLength, nums.size - slow)
        }

        return maxLength
    }
}