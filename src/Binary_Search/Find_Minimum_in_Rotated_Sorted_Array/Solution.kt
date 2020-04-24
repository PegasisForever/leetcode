package Binary_Search.Find_Minimum_in_Rotated_Sorted_Array

import kotlin.math.abs

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
class Solution {
    fun IntArray.circleGet(i: Int): Int {
        var index = if (i >= 0) {
            i % size
        } else {
            size + (i % size)
        }
        if (index == size) index = 0
        return get(index)
    }

    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var step = nums.size / 2
        var i = 0
        var lastNum = nums.circleGet(i)

        while (true) {
            i += step
            val num = nums.circleGet(i)
            if (num > nums.circleGet(i + 1)) return nums.circleGet(i + 1)
            step = if (num > lastNum) {
                if (abs(step) <= 1) {
                    1
                } else {
                    abs(step) / 2
                }
            } else {
                if (abs(step) <= 1) {
                    -1
                } else {
                    -abs(step) / 2
                }
            }
            lastNum = num
        }
    }
}