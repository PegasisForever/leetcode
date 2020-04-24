package Binary_Search.Find_Peak_Element

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            val isDescending = if (mid == nums.lastIndex) true else nums[mid] > nums[mid + 1]
            if (isDescending) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}