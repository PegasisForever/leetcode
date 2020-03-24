package Array_and_String.Move_Zeroes

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1174/
class Solution {
    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty()) return

        var left = 0
        var right = 0
        while (right < nums.size) {
            if (nums[right] != 0) {
                nums[left] = nums[right]
                left++
            }
            right++
        }

        for (i in nums.size - 1 downTo left) {
            nums[i] = 0
        }
    }
}