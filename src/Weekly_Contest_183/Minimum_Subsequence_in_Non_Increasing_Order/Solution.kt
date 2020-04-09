package Weekly_Contest_183.Minimum_Subsequence_in_Non_Increasing_Order

//https://leetcode.com/contest/weekly-contest-183/problems/minimum-subsequence-in-non-increasing-order/
class Solution {
    fun minSubsequence(nums: IntArray): List<Int> {
        val sum = nums.sum()
        var newSum = 0
        val newList = arrayListOf<Int>()
        nums.sorted().asReversed().forEach { num ->
            newSum += num
            newList.add(num)
            if (newSum > sum - newSum) {
                return newList
            }
        }

        error("wtf")
    }
}