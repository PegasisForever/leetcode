package Weekly_Contest_193.Running_Sum_of_1d_Array

//https://leetcode.com/contest/weekly-contest-193/problems/running-sum-of-1d-array/
class Solution {
    fun runningSum(nums: IntArray): IntArray {
        return nums.rs()
    }

    fun IntArray.rs(): IntArray {
        val result = IntArray(size)
        forEachIndexed { index, number ->
            result[index] = if (index == 0) {
                number
            } else {
                number + result[index - 1]
            }
        }
        return result
    }
}
