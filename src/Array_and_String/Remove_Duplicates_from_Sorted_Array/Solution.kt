package Array_and_String.Remove_Duplicates_from_Sorted_Array

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var left = 0
        var right = 0
        while (right < nums.size) {
            if (nums[right] != nums[left]) {
                left++
                nums[left] = nums[right]
            }
            right++
        }

        return left + 1
    }
}