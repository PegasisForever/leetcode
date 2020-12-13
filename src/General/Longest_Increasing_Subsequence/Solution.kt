package General.Longest_Increasing_Subsequence

// https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // dp[i] represents length of LIS ends with nums[i]
        val dp = IntArray(nums.size) { 1 }

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        return dp.max()!!
    }
}
