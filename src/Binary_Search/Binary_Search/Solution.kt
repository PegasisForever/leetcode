package Binary_Search.Binary_Search

//https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        var mid = (left + right) / 2
        while (nums[mid] != target) {
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
            if (right < left) return -1
            mid = (left + right) / 2
        }
        return mid
    }
}
