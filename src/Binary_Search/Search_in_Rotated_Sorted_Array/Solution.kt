package Binary_Search.Search_in_Rotated_Sorted_Array

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        var rotationPoint = -1
        for (i in 0 until nums.lastIndex) {
            if (nums[i] > nums[i + 1]) {
                rotationPoint = i
                break
            }
        }
        if (rotationPoint >= 0) {
            reverse(nums, 0, rotationPoint)
            reverse(nums, rotationPoint + 1, nums.lastIndex)
        } else {
            reverse(nums, 0, nums.lastIndex)
        }

        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return when {
                    rotationPoint == -1 -> nums.lastIndex - mid
                    mid > rotationPoint -> rotationPoint + (nums.size - mid)
                    else -> rotationPoint - mid
                }
                nums[mid] < target -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return -1
    }

    fun reverse(array: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        repeat((j - i + 1) / 2) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
            i++
            j--
        }
    }
}