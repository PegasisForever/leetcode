package General.Partition_Equal_Subset_Sum

fun main() {
    Solution().canPartition(intArrayOf(1, 5, 11, 5))
}

// https://leetcode.com/problems/partition-equal-subset-sum/
class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val half = sum / 2

        val dp = BooleanArray(half + 1)
        dp[0] = true
        for (num in nums) {
            for (i in half downTo num) {
                dp[i] = dp[i] || dp[i - num]
            }
            if (dp[half]) return true
        }

        return false
    }
}
