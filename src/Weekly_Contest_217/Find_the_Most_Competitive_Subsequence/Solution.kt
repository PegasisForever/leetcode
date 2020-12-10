package Weekly_Contest_217.Find_the_Most_Competitive_Subsequence

import println
import java.util.*
import java.util.Deque


fun main() {
    Solution().mostCompetitive(intArrayOf(3,5,2,6), 2).println()
}

// https://leetcode.com/problems/find-the-most-competitive-subsequence/
class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stack: Deque<Int> = ArrayDeque()
        for (i in nums.indices) {
            while (stack.isNotEmpty() && nums[i] < stack.peek() && nums.size - i + stack.size > k) {
                stack.pop()
            }
            if (stack.size < k) {
                stack.push(nums[i])
            }
        }

        return stack.toIntArray().reversedArray()
    }
}
