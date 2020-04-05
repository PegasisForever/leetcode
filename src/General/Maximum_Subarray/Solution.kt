package General.Maximum_Subarray

import kotlin.math.max

fun main() {
    val data = arrayOf(
        intArrayOf(0, 2, 2, 2, 5, 1, 7, 7, 7, 7, 7, 7)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.maxSubArray(d))
    }
}

//https://leetcode.com/problems/maximum-subarray/solution/
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var currSum = nums[0]
        var maxSum = nums[0]
        nums.forEachIndexed { i, num ->
            if (i == 0) return@forEachIndexed
            currSum = max(num, currSum + num)
            maxSum = max(maxSum, currSum)
        }
        return maxSum
    }
}