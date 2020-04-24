package Binary_Search.Search_for_a_Range

fun main() {
    Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var leftBound = -1

        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            val isLeftMostTarget =
                if (mid == 0)
                    nums[mid] == target
                else
                    (nums[mid] == target && nums[mid - 1] != target)
            if (isLeftMostTarget) {
                leftBound = mid
                break
            } else {
                if (nums[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        if (leftBound == -1) return intArrayOf(-1, -1)

        var rightBound = -1
        left = leftBound
        right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            val isRightMostTarget =
                if (mid == nums.lastIndex)
                    nums[mid] == target
                else
                    (nums[mid] == target && nums[mid + 1] != target)
            if (isRightMostTarget) {
                rightBound = mid
                break
            } else {
                if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return intArrayOf(leftBound, rightBound)

    }
}